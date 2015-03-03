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

    @Test
    public void canCreateCorrectFullCryptStringFromRequiredFields() throws Exception {
        String vendor = "chipbuttysrus";
        String amount = "22.22";
        String randomTxCodePart = "555555";
        String encryptionPassword = "4X4CauKt56wYcM2M";

        String registration = new FormRegistrationGenerator(vendor, amount).
                generateRegistrationString(randomTxCodePart);

        String actualCryptString = AESCryptoUtils.encryptToSagepayStandard(registration, encryptionPassword);

        String expectedCryptString = "@A43D9327394562648A6CF8AF619A6A41173C1863F18FE89475D4293CDDA9A142CBE1E882B483FB1159A65F8CB7B430BA05B89884E8CB3676D3E921429963B6F69A14845B59ABC42D74DD66EADE50298F91FADEC8E26AA58A7BE7C012889B8DE4B1C1AC7815B327F21E7D1574D70126464A8D556F5D1BB3F850E40374C8CDF312335ABBF698DAC6217F6EE94B10AADACA81804749A983E5DC81A803EFE7810D0315AF15C2841F14E3B8855C71349F0D9ADB4D9D22735A9893FB20365B878925E3F750ED6767FA238FD1D4F611D9A11530B238BDA21698E77B361C3F7A74AA91CE46F40274EF04B7D4B51D6101C924001B342FEA812F5ECB5F0564ED3018B8A87F920AEDE4656BE28B2AC1B09CEBA1806915175D45BB09EA81AD4EF4D34B305CCDDBAF6B8DA46D0BCDEB2141CA80364FB3E8FBD1EFFB8CBA84B15B734B9A2C4A4DF3512E00882BD1D53A55BC3BD4212BB3943CA5EC65FE345EDA7F761E6999F56DA1CB73DE4EEBD582C221BBA07A7909B880B5806505E066B56D7095B0D2814035BB02A91728E4DCEEF1F081B67A6A178A081C36DEA12373BA4038AC6F416E43A95299539CBF371F60247D7CE2A2A0A7DF90C08BD7088EAEF91D7042BF4A63D8B8E50284630591A9F5E957EA5F52796575C0814FD1221DFF68E10A92C5F5F9E39611D0FFE02A1F127B8E195AF0221E3DDD773AE050DB3F39DCB8A1B60FE28B9242E1D0374D7298907FEB55C2FF0D3A0C6055E544DEF4AEB40AE4857221F51ED08EA1CC0661071DCA7C52F896EAEE225C775B9653B47C8787B45376682FC3A549C7253FA0C9BC90B597B195FD8F80E937397B1D97FECD4B1977829C9111F2A9312D9FCD75D97B2C7D3E6811E2615609B81588B39E22180EEA07E162A4BF0ECF2EF62039C5860D9AB79A07AE08343B44DC8C85BCF233D8E74CF0122B71D6B39205B451AFAD6E2745D4CA8075FBBB69B1A84D53E00409A43E43EA3721E67DC0FB6036E90889DF4029652DF4A894F744FBB311A77F146FB42076783EE1A5E831960FADBBAD8D565430E62F21B5A4A8BF140598F24B489F7FB0FBAD5983604A1913838540EACFD315356AB83D017A39418B4A8B6C69EF603A647510E26D3D5A89E44F20FFF4D9EAB1F1F04A2E0E2472625881800F4DD262C37CFD2D2D490920A0ECEBBE11A3CAF5672997FA9226E0E6E3AA7707";
        assertEquals(expectedCryptString, actualCryptString);
    }
}
