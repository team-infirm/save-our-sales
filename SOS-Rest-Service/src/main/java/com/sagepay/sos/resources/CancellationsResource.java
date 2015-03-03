package com.sagepay.sos.resources;

import com.sagepay.sos.core.Cancellation;
import com.sagepay.sos.db.CancellationsDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/cancellations")
public class CancellationsResource {

    private final CancellationsDAO dao;

    public CancellationsResource(CancellationsDAO dao){
        this.dao = dao;
    }

    @GET
    public List<Cancellation> getAllCancellations(){
        return dao.getAllCancellations();
    }
}
