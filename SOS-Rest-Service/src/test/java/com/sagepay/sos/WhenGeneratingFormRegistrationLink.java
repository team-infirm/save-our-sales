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

    @Test
    public void canCreateAFullFormRegistrationGivenRequiredFields() {
        String vendor = "chipbuttysrus";
        String amount = "22.22";
        String randomTxCodePart = "555555";

        String actualRegistration = new FormRegistrationGenerator(vendor, amount).
                generateRegistrationString(randomTxCodePart);

        String expectedRegistration = "VendorTxCode=chipbuttysrus-1386062555555&Amount=22.22&Currency=GBP&Description=TESTPAYMENT&SuccessURL=http://www.google.com/sagepay-java-kit-1.2.2.0/form/success/&FailureURL=http://www.google.com/sagepay-java-kit-1.2.2.0/form/failure/&BillingSurname=Surname&BillingFirstnames=Fname Mname&BillingAddress1=BillAddress Line 1&BillingCity=BillCity&BillingPostCode=W1A 1BL&BillingCountry=GB&DeliverySurname=Surname&DeliveryFirstnames=Fname Mname&DeliveryAddress1=BillAddress Line 1&DeliveryCity=BillCity&DeliveryPostCode=W1A 1BL&DeliveryCountry=GB&CustomerName=Fname Mname Surname&CustomerEMail=customer@example.com&SendEMail=1&eMailMessage=Thanks for your order&BillingAddress2=BillAddress Line 2&BillingPhone=44 (0)7933 000 000&DeliveryAddress2=BillAddress Line 2&DeliveryPhone=44 (0)7933 000 000&AllowGiftAid=0&ApplyAVSCV2=0&Apply3DSecure=0";

        assertEquals(expectedRegistration, actualRegistration);
    }
}
