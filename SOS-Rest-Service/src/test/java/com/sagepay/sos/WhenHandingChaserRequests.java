package com.sagepay.sos;

import com.sagepay.sos.core.ChaserRequest;
import com.sagepay.sos.core.ChaserRequestContent;
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
        chaserRequest.setChaserRequestContents(new ArrayList<ChaserRequestContent>(
                Arrays.asList(new ChaserRequestContent("{123451}", "14.99"),
                              new ChaserRequestContent("{123452}", "24.99"))
            ));
        chaserResource.sendChaser(chaserRequest);
    }
}
