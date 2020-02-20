package io.turntabl.Empire.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.Empire.models.ProjectTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api
@RestController
public class ProjectController {
    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @ApiOperation("Add a Project")
    @PostMapping("/api/v1/addNewProject")
    public void addNewProject(ProjectTO project) {
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
                "select * from projects",
                new BeanPropertyRowMapper<ProjectTO>(ProjectTO.class)
        );
    }

}
