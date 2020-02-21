package io.turntabl.Empire.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Empire.models.ProjectTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;


@Api
@RestController
public class ProjectController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a Project")
    @PostMapping("/api/v1/addNewProject")
    public void addNewProject(@RequestBody ProjectTO project) {
        template.update(
                "insert into project(project_name) values(?)",
                project.getProject_name()
        );
    }

    @CrossOrigin
    @ApiOperation("Get all Projects")
    @GetMapping("/api/v1/projects")
    public List<ProjectTO> viewAllProjects() {
        return this.template.query(
                "select * from project",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class)
        );
    }

    @CrossOrigin
    @ApiOperation("Get a Project By Id")
    @GetMapping("/api/v1/project/{id}")
    public ProjectTO viewProjectById(@PathVariable ("id") Integer id) {
        return (ProjectTO) template.queryForObject(
                "select * from project where project_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(ProjectTO.class)
        );
    }

}
