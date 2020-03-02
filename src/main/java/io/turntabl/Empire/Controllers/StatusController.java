package io.turntabl.Empire.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Empire.models.StatusTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Api
@RestController
public class StatusController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Get All Status")
    @GetMapping("api/v1/status")
    public List<StatusTO> viewAllStatus() {
        return this.template.query("select project_name, status, endpoint_id, status_date from status",
        new BeanPropertyRowMapper<StatusTO>(StatusTO.class));
    }

    @CrossOrigin
    @ApiOperation("Get Status By Current Date")
    @GetMapping("api/v2/status/{current_date}")
    public List<StatusTO> getStatusByDate() {
        return template.query("select status, endpoint_id, status_date from status where status_date = current_date",
        new BeanPropertyRowMapper<>(StatusTO.class));
    }
}
