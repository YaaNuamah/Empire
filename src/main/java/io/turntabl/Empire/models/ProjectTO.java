package io.turntabl.Empire.models;

public class ProjectTO {
    private Integer project_id;
    private String project_name;

    public ProjectTO() {}

    public ProjectTO(Integer project_id, String project_name) {
        this.project_id = project_id;
        this.project_name = project_name;
    }

    public Integer getProject_id() { return project_id; }

    public void setProject_id(Integer project_id) { this.project_id = project_id; }

    public String getProject_name() { return project_name; }

    public void setProject_name(String project_name) { this.project_name = project_name; }

    @Override
    public String toString() {
        return "ProjectTO{" +
                "project_id='" + project_id + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }
}

