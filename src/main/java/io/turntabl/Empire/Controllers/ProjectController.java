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
                "insert into turntabl_project(project_name) values(?)",
                project.getProject_name()
        );
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
    public ProjectTO viewProjectById(@PathVariable ("id") Integer id) {
        return (ProjectTO) template.queryForObject(
                "select project_id, project_name from turntabl_project where project_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(ProjectTO.class)
        );
    }


//    @CrossOrigin
//    @PatchMapping("/api/v1/project/{id}")
//    public void updateProject(@RequestBody ProjectTO project, @PathVariable("id") String id) {
//        return ProjectTO
//    }
//    @CrossOrigin
//    @PatchMapping("/api/v1/stories/{id}")
//    public void updateStory(@RequestBody StoryTO uStory, @PathVariable("id") String id) {
//        StoryTO story = db.find(StoryTO.class, id);
//
//        story.setAuthor_id(uStory.getAuthor_id());
//        story.setStory_title(uStory.getStory_title());
//        story.setStory_description(uStory.getStory_description());
//        story.setCategory_id(uStory.getCategory_id());
//        story.setStory_photo(uStory.getStory_photo());
//
//        Response response = db.update(story);
//    }

}
