package com.sagepay.sos;

import com.sagepay.sos.core.Cancellation;
import com.sagepay.sos.dao.TestCancellationsDAO;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WhenUsingCancellationsDao {

    @Test
    public void testStoreAndRetrieve() {
        Cancellation cancellation = new Cancellation();
        cancellation.setExecutedTime(DateTime.now().toString());
        cancellation.setTransactionId("12345");
        cancellation.setTransactionValue("12345");
        TestCancellationsDAO dao = new TestCancellationsDAO();
        dao.saveCancellation(cancellation);

        List<Cancellation> retrievedCancellations = dao.getAllCancellations();
        Assert.assertTrue("Expected 1 cancellation to be stored", retrievedCancellations.size() == 6);
    }
}
