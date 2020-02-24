package io.turntabl.Empire.Controllers;

import io.turntabl.Empire.models.EndpointTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class EndpointController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a new Endpoint")
    @PostMapping("/api/v1/addNewEndpoint")
    public void addNewEndpoint(@RequestBody EndpointTO endpoint) {
        template.update(
                "insert into endpoints(endpoint_url, request_method) values(?,?)",
                endpoint.getEndpoint_url(),
                endpoint.getRequest_method()
        );
    }

    @CrossOrigin
    @ApiOperation("Get    all Endpoints")
    @GetMapping("/api/vi/endpoints")
    public List<EndpointTO> viewAllEndpoints() {
        return this.template.query(
                "select endpoint_url, request_method from endpoints",
                new BeanPropertyRowMapper<EndpointTO>(EndpointTO.class)
        );
    }

    @CrossOrigin
    @ApiOperation("Get an Endpoint By Id")
    @GetMapping("/api/v1/endpoints/{id}")
    public EndpointTO viewEndpointById(@PathVariable("id") Integer id) {
        return (EndpointTO) template.queryForObject(
                "select endpoint_url, request_method from endpoints where endpoint_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(EndpointTO.class)
        );
    }
}
