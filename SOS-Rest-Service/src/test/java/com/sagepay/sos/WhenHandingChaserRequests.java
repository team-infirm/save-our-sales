package com.sagepay.sos;

import com.sagepay.sos.core.ChaserRequest;
import com.sagepay.sos.dao.TestCancellationsDAO;
import com.sagepay.sos.resources.ChaserResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class WhenHandingChaserRequests {

    @Test
    public void canSendValidEmailsWithLinkWhenChasersRequested() {
        TestCancellationsDAO dao = new TestCancellationsDAO();
        ChaserResource chaserResource = new ChaserResource(dao);
        ChaserRequest chaserRequest = new ChaserRequest();
        chaserRequest.setTransactionId(new ArrayList<String>(Arrays.asList("{123451}", "{123452}")));
        chaserResource.sendChaser(chaserRequest);
    }
}
