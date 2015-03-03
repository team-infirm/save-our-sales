package com.sagepay.sos;

import com.sagepay.sos.gateway.AESCryptoUtils;
import com.sagepay.sos.gateway.FormRegistrationGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhenGeneratingFormRegistrationLink {

    @Test
    public void canCreateACryptStringGivenSomeData() throws Exception {
        String inputDigest = "field1=value1&field2=value2";
        String encryptionPassword = "4X4CauKt56wYcM2M";
        String expectedCrypt = "@EE2491D0B9C03525F523AA4C7C79E9AF5940EE41D7729AD76BAF72A0017445E9";

        String actualCrypt = new AESCryptoUtils().encryptToSagepayStandard(inputDigest, encryptionPassword);

        assertEquals(expectedCrypt, actualCrypt);
    }
}
