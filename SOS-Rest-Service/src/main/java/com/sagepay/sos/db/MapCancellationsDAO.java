package com.sagepay.sos.db;

import com.sagepay.sos.core.Cancellation;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapCancellationsDAO implements CancellationsDAO{

    private HashMap<String, Cancellation> cancellations = new HashMap<>();

    public MapCancellationsDAO() {}

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
