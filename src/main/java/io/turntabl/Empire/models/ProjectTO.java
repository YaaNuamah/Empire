package io.turntabl.Empire.models;

import java.util.List;

public class ProjectTO {

    private Integer project_id;
    private String project_name;
    private List<EndpointTO> endpoints;

    public ProjectTO() {}

    public ProjectTO(Integer project_id, String project_name, List<EndpointTO> endpoints) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.endpoints = endpoints;
    }

    public Integer getProject_id() { return project_id; }

    public void setProject_id(Integer project_id) { this.project_id = project_id; }

    public String getProject_name() { return project_name; }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public List<EndpointTO> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<EndpointTO> endpoints) {
        this.endpoints = endpoints;
    }

    @Override
    public String toString() {
        return "ProjectTO{" +
                "project_id='" + project_id + '\'' +
                ", project_name='" + project_name + '\'' +
                '}';
    }
}

