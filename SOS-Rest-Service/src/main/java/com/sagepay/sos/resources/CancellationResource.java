package com.sagepay.sos.resources;

import com.sagepay.sos.core.Cancellation;
import com.sagepay.sos.db.CancellationsDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cancellation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CancellationResource {

    private final CancellationsDAO dao;

    public CancellationResource(CancellationsDAO dao){
        this.dao = dao;
    }

    @POST
    public Cancellation storeCancellation(Cancellation cancellation){
        //TODO: save the cancellation somewhere....
        return null;
    }
}
