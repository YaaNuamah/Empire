package io.turntabl.Empire.Dao;
import io.turntabl.Empire.models.EndpointTO;

import java.util.List;


public interface EndpointDao {
    public void addNewEndpoint(EndpointTO endpoint);
    public List<EndpointTO> viewAllEndpoints();
    public EndpointTO viewEndpointById(Integer id);
}
