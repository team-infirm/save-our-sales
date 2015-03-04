package com.sagepay.sos.resources;

import com.sagepay.sos.core.Cancellation;
import com.sagepay.sos.db.CancellationsDAO;
import com.sagepay.sos.gateway.AESCryptoUtils;
import org.joda.time.DateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/transaction-failure")
public class TransactionFailureEndpoint {

    private final CancellationsDAO cancellationDAO;

    private static final String HARDCODED_VENDOR_PASSWORD = "4X4CauKt56wYcM2M";

    public TransactionFailureEndpoint(CancellationsDAO cancellationsDAO) {
        this.cancellationDAO = cancellationsDAO;
    }

    @GET
    public String registerFailedTransaction(@QueryParam("crypt") String cryptString, @QueryParam("customerMobileNumber") String customerMobileNumber, @QueryParam("customerEmailAddress") String customerEmailAddress) throws Exception {
        String queryParams = AESCryptoUtils.decryptCryptString(cryptString, HARDCODED_VENDOR_PASSWORD);
        Map<String, String> paramMap = getQueryParamMap(queryParams);
        String vpsTxId = paramMap.get("VPSTxId");
        String amount = paramMap.get("Amount");
        registerCancellation(customerMobileNumber, customerEmailAddress, amount, vpsTxId);
        return "Shame you cancelled your transaction....:-(";
    }

    private static Map<String, String> getQueryParamMap(String queryParams){
        String[] params = queryParams.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params){
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    private void registerCancellation(String customerMobileNumber, String customerEmailAddress, String amount, String vpsTxId) {
        Cancellation c = new Cancellation();
        c.setCustomerEmail(customerEmailAddress);
        c.setCustomerMobileNumber(customerMobileNumber);
        c.setExecutedTime(DateTime.now().toString());
        c.setHasBeenRecoveredPreviously(false);
        c.setTransactionValue(amount);
        c.setVendorId("123456");
        c.setVendorName("chipbuttysrus");
        c.setTransactionId(vpsTxId);
        cancellationDAO.saveCancellation(c);
    }
}
