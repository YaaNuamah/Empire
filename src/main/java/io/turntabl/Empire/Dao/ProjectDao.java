package io.turntabl.Empire.Dao;
import io.turntabl.Empire.models.ProjectTO;

import java.util.List;

public interface ProjectDao {
    public void addNewProject(ProjectTO project);
    public List<ProjectTO> viewAllProjects();
    public ProjectTO viewProjectById();
}
