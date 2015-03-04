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

@Path("/transaction-success")
public class TransactionSuccessEndpoint {

    private final CancellationsDAO cancellationDAO;

    private static final String HARDCODED_VENDOR_PASSWORD = "4X4CauKt56wYcM2M";

    public TransactionSuccessEndpoint(CancellationsDAO cancellationsDAO) {
        this.cancellationDAO = cancellationsDAO;
    }

    @GET
    public void registerSuccessfulTransaction(@QueryParam("crypt") String cryptString, @QueryParam("customerMobileNumber") String customerMobileNumber, @QueryParam("customerEmailAddress") String customerEmailAddress) throws Exception {
        String queryParams = AESCryptoUtils.decryptCryptString(cryptString, HARDCODED_VENDOR_PASSWORD);
        Map<String, String> paramMap = getQueryParamMap(queryParams);
        String vendorId = paramMap.get("vendorId");
        String vendorName = paramMap.get("vendorName");
        String amount = paramMap.get("amount");
        String transactionId = paramMap.get("vpsTxId");
        registerSuccessfulChaser(transactionId,vendorId, vendorName, amount);
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

    private void registerSuccessfulChaser(String transactionId, String vendorId, String vendorName, String amount) {
        Cancellation c = cancellationDAO.getCancellation(transactionId);
        c.setExecutedTime(DateTime.now().toString());
        if (c.getHasBeenRecoveredPreviously() == true){
            c.setHasBeenSuccessfullyRecovered(true);
        }
        c.setTransactionValue(amount);
        cancellationDAO.saveCancellation(c);
    }
}
