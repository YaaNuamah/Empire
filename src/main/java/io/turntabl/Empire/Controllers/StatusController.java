package io.turntabl.Empire.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Empire.models.StatusTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Api
@RestController
public class StatusController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add status")
    @PostMapping("api/v1/addStatus")
    public void addStatus(@RequestBody StatusTO status) {
        template.update("insert into status(project_id, status, endpoint_id) values (?,?,?)",
                status.getProject_id(),
                status.getStatus(),
                status.getEndpoint_id());

    }

    @CrossOrigin(origins = "*")
    @ApiOperation("Get All Status")
    @GetMapping("api/v1/status")
    public List<StatusTO> viewAllStatus() {
        return this.template.query("select endpoint_url, turntabl_project.project_name, endpoints.request_method, status, status.project_id, status.endpoint_id, cast(time as timestamp(0)), status_date from status inner join endpoints on status.endpoint_id = endpoints.endpoint_id inner join turntabl_project on status.project_id = turntabl_project.project_id order by time desc",
                 new BeanPropertyRowMapper<StatusTO>(StatusTO.class));
    }

    @CrossOrigin(origins = "*")
    @ApiOperation("Get Status By Project Id")
    @GetMapping("/api/v1/status/{project_id}")
    public List<StatusTO> getStatusByProjectId(@PathVariable("project_id") Integer project_id) {
        return this.template.query("select project_name, status, endpoint_url, cast(time as timestamp(0)), request_method from turntabl_project inner join endpoints on turntabl_project.project_id = endpoints.project_id inner join status on status.project_id = endpoints.project_id where turntabl_project.project_id = ? order by time desc limit 20",
        new Object[]{project_id},
        new BeanPropertyRowMapper<>(StatusTO.class));

    }

    @CrossOrigin(origins = "*")
    @ApiOperation("Get Status By Current Date")
    @GetMapping("api/v2/status/{current_date}")
    public List<StatusTO> getStatusByCurrentDate() {
        return template.query(" select endpoint_url, turntabl_project.project_name, endpoints.request_method, status, status.project_id, status.endpoint_id, cast(time as timestamp(0)), status_date from status inner join endpoints on status.endpoint_id = endpoints.endpoint_id inner join turntabl_project on status.project_id = turntabl_project.project_id where status_date = current_date order by time desc",
        new BeanPropertyRowMapper<>(StatusTO.class));
    }

    @CrossOrigin(origins = "*")
    @ApiOperation("Get Status By Previous Date")
    @GetMapping("api/v2/status/{previous_date}")
    public List<StatusTO> getStatusByPreviousDate() {
        return template.query("select endpoint_url, turntabl_project.project_name, endpoints.request_method, status, status.project_id, status.endpoint_id, cast(time as timestamp(0)), status_date from status inner join endpoints on status.endpoint_id = endpoints.endpoint_id inner join turntabl_project on status.project_id = turntabl_project.project_id where status_date = current_date - interval '1 day' order by time desc",
        new BeanPropertyRowMapper<>(StatusTO.class));
    }

    @CrossOrigin(origins = "*")
    @ApiOperation("Remove Status By System Date")
    @DeleteMapping("api/v2/status")
    public void deleteStatusBySystemDate() {
        this.template.update("delete from status where status_date = current_date - interval '1 day' ");

    }
}
