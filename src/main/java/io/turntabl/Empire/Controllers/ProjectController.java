package io.turntabl.Empire.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Empire.models.ProjectTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api
@RestController
public class ProjectController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a Project")
    @PostMapping("/api/v1/addNewProject")
    public Object addNewProject(@RequestBody ProjectTO project) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template)
                .withTableName("turntabl_project")
                .usingGeneratedKeyColumns("project_id");
        Map<String, Object> parameters = new HashMap<>();
        Object project_name = new Object();
        parameters.put("project_name",project.getProject_name());

        Number key = insert.executeAndReturnKey(parameters);

        Map<String, Object> results = new HashMap<>();
        results.put("key", key.intValue());

        return results;

    }

    @CrossOrigin
    @ApiOperation("Get all Projects")
    @GetMapping("/api/v1/projects")
    public List<ProjectTO> viewAllProjects() {
        return this.template.query(
                "select project_id, project_name from turntabl_project",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class)
        );
    }

    @CrossOrigin
    @ApiOperation("Get a Project By Id")
    @GetMapping("/api/v1/project/{id}")
    public ProjectTO viewProjectById(@PathVariable("id") Integer id) {
        return (ProjectTO) template.queryForObject(
                "select project_id, project_name from turntabl_project where project_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(ProjectTO.class)
        );
    }

}