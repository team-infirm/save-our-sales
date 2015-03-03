package com.sagepay.sos;

import com.sagepay.sos.core.Cancellation;
import com.sagepay.sos.db.CancellationsDAO;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestCancellationsDAO {

    @Test
    public void testStoreAndRetrieve() {
        Cancellation cancellation = new Cancellation();
        cancellation.setExecutedTime(DateTime.now());
        cancellation.setTransactionId("12345");
        cancellation.setTransactionValue(12345);
        CancellationsDAO dao = new CancellationsDAO();
        dao.saveCancellation(cancellation);


        List<Cancellation> retrievedCancellations = dao.getAllCancellations();
        Assert.assertTrue("Expected 1 cancellation to be stored", retrievedCancellations.size() == 1);
    }
}
