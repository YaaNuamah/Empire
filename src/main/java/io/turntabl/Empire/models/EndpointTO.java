package io.turntabl.Empire.models;

public class EndpointTO {
    private Integer project_id;
    private String endpoint_url;
    private String request_method;

    public EndpointTO() { }

    public EndpointTO(Integer endpoint_id, Integer project_id, String endpoint_url, String request_method) {
        this.project_id = project_id;
        this.endpoint_url = endpoint_url;
        this.request_method = request_method;
    }

    public Integer getProject_id() { return project_id; }

    public void setProject_id(Integer project_id) { this.project_id = project_id; }

    public String getEndpoint_url() { return endpoint_url; }

    public void setEndpoint_url(String endpoint_url) { this.endpoint_url = endpoint_url; }

    public String getRequest_method() { return request_method; }

    public void setRequest_method(String request_method) { this.request_method = request_method; }

    @Override
    public String toString() {
        return "EndpointTO{" +
                ", project_id=" + project_id +
                ", endpoint_url='" + endpoint_url + '\'' +
                ", request_method='" + request_method + '\'' +
                '}';
    }
}
