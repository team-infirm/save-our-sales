package com.sagepay.sos.resources;

import com.sagepay.sos.core.ChaserRequest;
import com.sagepay.sos.core.Cancellation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/chasers")
@Produces (MediaType.APPLICATION_JSON)
public class ChaserResource {

    @POST
    public void sendChaser(ChaserRequest chaserRequest){
        for (String id : chaserRequest.getTransactionIds()){
            System.out.println("Sending email for cancellation with an id of " + id);
        }
    }
}
