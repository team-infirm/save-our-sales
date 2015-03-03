package com.sagepay.sos;

import com.sagepay.sos.aws.EmailSender;
import com.sagepay.sos.aws.SmsSender;
import org.apache.commons.mail.EmailException;
import org.junit.Test;

public class TestSender {
    @Test
    public void sendTestEmail() throws EmailException {
        EmailSender.sendEmail("stu.wilson@sagepay.com","Hi We noticed you didn't complete your purchase through our on-line store. We hope you didn't encounter difficulties, if you'd like to try again, click the link below. As a gesture of goodwill, we've applied a discount to your original order and the new amount is [XX.XX GBP]. Many Thanks www.webstore.com", "Test");
    }

    @Test
    public void sendTestSMS() throws Exception {
        SmsSender.sendSMS("447983363025", "Test SMS");
    }
}
