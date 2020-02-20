package io.turntabl.Empire.models;

public class EndpointTO {
    private Integer endpoint_id;
    private Integer project_id;
    private String endpoint_url;
    private String request_method;

    public EndpointTO() { }

    public EndpointTO(Integer endpoint_id, Integer project_id, String endpoint_url, String request_method) {
        this.endpoint_id = endpoint_id;
        this.project_id = project_id;
        this.endpoint_url = endpoint_url;
        this.request_method = request_method;
    }
}
