package com.sagepay.sos.db;

import com.sagepay.sos.core.Cancellation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 3/4/2015.
 */
public interface CancellationsDAO {

    public List<Cancellation> getAllCancellations();

    public Cancellation getCancellation(String id);

    public void saveCancellation(Cancellation cancellation);
}
