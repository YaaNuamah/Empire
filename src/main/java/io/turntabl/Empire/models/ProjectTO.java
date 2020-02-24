package io.turntabl.Empire.models;

public class ProjectTO {
    private String project_name;

    public ProjectTO() {}

    public ProjectTO(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_name() { return project_name; }

    public void setProject_name(String project_name) { this.project_name = project_name; }

    @Override
    public String toString() {
        return "ProjectTO{" +
                ", project_name='" + project_name + '\'' +
                '}';
    }
}

