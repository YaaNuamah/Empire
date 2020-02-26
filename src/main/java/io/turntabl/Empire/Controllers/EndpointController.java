package io.turntabl.Empire.Controllers;

import io.turntabl.Empire.models.EndpointTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api
@RestController
public class EndpointController {
    @Autowired
    JdbcTemplate template;


    public  String getstatus(String url){

        String result = "";
        int code = 200;
        try{
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();

            code = connection.getResponseCode();
            if (code == 200) {

                System.out.println("green \t" + url);

            }
            else {
                System.out.println("red \t" + url);

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  result;
    }

    @CrossOrigin
    @ApiOperation("Add a new Endpoint")
    @PostMapping("/api/v1/addNewEndpoint")
    public void addNewEndpoint(@RequestBody EndpointTO endpoint) {
        template.update(
                "insert into endpoints(project_id, endpoint_url, request_method) values(?,?,?)",
                endpoint.getProject_id(),
                endpoint.getEndpoint_url(),
                endpoint.getRequest_method()
        );
    }

    @CrossOrigin
    @ApiOperation("Get all Endpoints")
    @GetMapping("/api/v1/endpoints")
    public List<EndpointTO> viewAllEndpoints() {
        return this.template.query(
                "select endpoint_id, project_id, endpoint_url, request_method from endpoints",
                new BeanPropertyRowMapper<EndpointTO>(EndpointTO.class)
        );
    }

    @CrossOrigin
    @ApiOperation("Get all Endpoints")
    @GetMapping("/api/v1/testcode")
    public List<String> viewssssssss() {
        List<EndpointTO> response  =  this.template.query(
                "select endpoint_url from endpoints",
                new BeanPropertyRowMapper<EndpointTO>(EndpointTO.class)
        );

        response.stream().map(endpoint -> endpoint.getEndpoint_url()).collect(Collectors.toList()).forEach(entry -> {
            getstatus(entry);
        });
        return  response.stream().map(endpoint -> endpoint.getEndpoint_url()).collect(Collectors.toList());
    }

    @CrossOrigin
    @ApiOperation("Get an Endpoint By Id")
    @GetMapping("/api/v1/endpoints/{id}")
    public EndpointTO viewEndpointById(@PathVariable("id") Integer id) {
        return (EndpointTO) template.queryForObject(
                "select project_id, endpoint_url, request_method from endpoints where endpoint_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(EndpointTO.class)
        );
    }
}
