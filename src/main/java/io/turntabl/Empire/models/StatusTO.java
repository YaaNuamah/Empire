package io.turntabl.Empire.models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class StatusTO {

    private String endpoint_url;
    private Integer project_id;
    private Integer status;
    private Integer endpoint_id;
    private String request_method;
    private String project_name;
    private Timestamp time;

    public StatusTO() {
    }

    public String getEndpoint_url() {
        return endpoint_url;
    }

    public void setEndpoint_url(String endpoint_url) {
        this.endpoint_url = endpoint_url;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEndpoint_id() {
        return endpoint_id;
    }

    public void setEndpoint_id(Integer endpoint_id) {
        this.endpoint_id = endpoint_id;
    }

    public String getRequest_method() {
        return request_method;
    }

    public void setRequest_method(String request_method) {
        this.request_method = request_method;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public StatusTO(String endpoint_url, Integer project_id, Integer status, Integer endpoint_id, String request_method, String project_name, Timestamp time) {
        this.endpoint_url = endpoint_url;
        this.project_id = project_id;
        this.status = status;
        this.endpoint_id = endpoint_id;
        this.request_method = request_method;
        this.project_name = project_name;
        this.time = time;


    }
}


