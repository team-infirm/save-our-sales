package com.sagepay.sos.db;

import com.sagepay.sos.core.Cancellation;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CancellationsDAO {

    private HashMap<String, Cancellation> cancellations = new HashMap<>();

    public CancellationsDAO(){
        for (int i = 0; i < 5; i++){
            Cancellation c = new Cancellation();
            c.setExecutedTime(DateTime.now());
            c.setTransactionId("{12345" + i + "}");
            c.setTransactionValue(i * 10);
            c.setHasBeenRecoveredPreviously(i%2==0 ? true : false);
            c.setVendorId("Vendor" + i);
            c.setVendorName("Vendor" + i);
            c.setCustomerEmail("chris.rutter@sagepay.com");
            cancellations.put(c.getTransactionId(), c);
        }
    }

    public void saveCancellation(Cancellation cancellation){
        cancellations.put(cancellation.getTransactionId(), cancellation);
    }

    public List<Cancellation> getAllCancellations(){
        return new ArrayList<Cancellation>(cancellations.values());
    }

    public Cancellation getCancellation(String id) {
        return cancellations.get(id);
    }
}
