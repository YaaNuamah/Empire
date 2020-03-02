package io.turntabl.Empire.models;



public class StatusTO {

    private String project_name;
    private Integer status;
    private Integer endpoint_id;

    public StatusTO() { }

    public StatusTO(String project_name, Integer status, Integer endpoint_id) {
        this.project_name = project_name;
        this.status = status;
        this.endpoint_id = endpoint_id;
    }

    public String getProject_name() { return project_name; }

    public void setProject_name(String project_name) { this.project_name = project_name; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Integer getEndpoint_id() { return endpoint_id; }

    public void setEndpoint_id(Integer endpoint_id) { this.endpoint_id = endpoint_id; }
}
