package com.sagepay.sos.gateway;

/**
 * Created by Chris on 3/3/2015.
 */
public class FormRegistrationGenerator {

    public static final String FORM_REGISTRATION_URL = "https://test.sagepay.com/gateway/service/vspform-register.vsp";
    public static final String QUERY_STRING_BEGIN = "?";
    private static final String DELIMITER = "&";
    private String vendor;
    private String amount;

    public FormRegistrationGenerator(String vendor, String amount) {
        this.vendor = vendor;
        this.amount = amount;
    }

    public String generateRegistrationString(String randomTxCodePart) {
        return "VendorTxCode=chipbuttysrus-1386062" + randomTxCodePart + "&Amount=" + amount + "&Currency=GBP&Description=TESTPAYMENT&SuccessURL=http://www.google.com/sagepay-java-kit-1.2.2.0/form/success/&FailureURL=http://www.google.com/sagepay-java-kit-1.2.2.0/form/failure/" +
                "&BillingSurname=Surname&BillingFirstnames=Fname Mname&BillingAddress1=BillAddress Line 1&BillingCity=BillCity&BillingPostCode=W1A 1BL&BillingCountry=GB&DeliverySurname=Surname&DeliveryFirstnames=Fname Mname&DeliveryAddress1=BillAddress Line 1" +
                "&DeliveryCity=BillCity&DeliveryPostCode=W1A 1BL&DeliveryCountry=GB&CustomerName=Fname Mname Surname&CustomerEMail=customer@example.com&SendEMail=1&eMailMessage=Thanks for your order&BillingAddress2=BillAddress Line 2&BillingPhone=44 (0)7933 000 000" +
                "&DeliveryAddress2=BillAddress Line 2&DeliveryPhone=44 (0)7933 000 000&AllowGiftAid=0&ApplyAVSCV2=0&Apply3DSecure=0";

    }

    public static String createRegistrationLink(String cryptString, String vendor) {
        StringBuilder linkBuilder = new StringBuilder();
        linkBuilder.append(FORM_REGISTRATION_URL);
        linkBuilder.append(QUERY_STRING_BEGIN);
        linkBuilder.append("VPSProtocol=3.00" + DELIMITER);
        linkBuilder.append("TxType=PAYMENT" + DELIMITER);
        linkBuilder.append("Vendor=" + vendor + DELIMITER);
        linkBuilder.append("Crypt=" + cryptString);

        return linkBuilder.toString();
    }
}
