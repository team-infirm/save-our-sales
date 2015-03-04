package com.sagepay.sos.db;

import com.sagepay.sos.core.Cancellation;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapCancellationsDAO implements CancellationsDAO{

    private HashMap<String, Cancellation> cancellations = new HashMap<>();

    public MapCancellationsDAO() {
        for (int i = 0; i < 5; i++){
            Cancellation c = new Cancellation();
            c.setExecutedTime(DateTime.now().toString());
            c.setTransactionId("{12345" + i + "}");
            c.setTransactionValue(Integer.toString(i) + ".00");
            c.setHasBeenRecoveredPreviously(i % 2 == 0 ? true : false);
            c.setVendorId("Vendor" + i);
            c.setVendorName("chipbuttysrus");
            c.setCustomerEmail("chris2605@hotmail.com");
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
