package com.sagepay.sos.resources;

import com.sagepay.sos.core.Cancellation;
import com.sagepay.sos.db.CancellationsDAO;
import org.joda.time.DateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/transaction-failure")
public class TransactionFailureEndpoint {

    private final CancellationsDAO cancellationDAO;

    public TransactionFailureEndpoint(CancellationsDAO cancellationsDAO) {
        this.cancellationDAO = cancellationsDAO;
    }

    @GET
    public void registerFailedTransaction(@QueryParam("crypt") String cryptString, @QueryParam("customerMobileNumber") String customerMobileNumber, @QueryParam("customerEmailAddress") String customerEmailAddress){
        //TODO: Decrypt cryptString.....for amount, vendorId, vendorName
        registerCancellation(customerMobileNumber, customerEmailAddress, "vendorId", "vendorName");
    }

    private void registerCancellation(String customerMobileNumber, String customerEmailAddress, String vendorId, String vendorName) {
        Cancellation c = new Cancellation();
        c.setCustomerEmail(customerEmailAddress);
        c.setCustomerMobileNumber(customerMobileNumber);
        c.setExecutedTime(DateTime.now());
        c.setHasBeenRecoveredPreviously(false);
        c.setTransactionValue(0);
        c.setVendorId("123456");
        c.setVendorName("TestVendorName");
        cancellationDAO.saveCancellation(c);
    }
}
