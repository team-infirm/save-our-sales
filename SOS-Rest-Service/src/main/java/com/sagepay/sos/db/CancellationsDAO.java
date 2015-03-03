package com.sagepay.sos.db;

import com.sagepay.sos.core.Cancellation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CancellationsDAO {

    private HashMap<String, Cancellation> cancellations = new HashMap<>();

    public CancellationsDAO(){

    }

    public void saveCancellation(Cancellation cancellation){
        cancellations.put(cancellation.getTransactionId(), cancellation);
    }

    public List<Cancellation> getAllCancellations(){
        return new ArrayList<Cancellation>(cancellations.values());
    }
}
