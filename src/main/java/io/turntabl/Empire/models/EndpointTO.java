package io.turntabl.Empire.models;

public class EndpointTO {
    private String endpoint_url;
    private String request_method;

    public EndpointTO() { }

    public EndpointTO(String endpoint_url, String request_method) {
        this.endpoint_url = endpoint_url;
        this.request_method = request_method;
    }

    public String getEndpoint_url() { return endpoint_url; }

    public void setEndpoint_url(String endpoint_url) { this.endpoint_url = endpoint_url; }

    public String getRequest_method() { return request_method; }

    public void setRequest_method(String request_method) { this.request_method = request_method; }

    @Override
    public String toString() {
        return "EndpointTO{" +
                ", endpoint_url='" + endpoint_url + '\'' +
                ", request_method='" + request_method + '\'' +
                '}';
    }
}
