package com.sagepay.sos.aws;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {

    private static final String FROM_EMAIL_ADDRESS = "incomplete.orders@gmail.com";
    private static final String GMAIL_PASSWORD = "sagepay123";
    public static void sendEmail(String recipient, String body, String subject) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(FROM_EMAIL_ADDRESS, GMAIL_PASSWORD));
        email.setSSLOnConnect(true);
        email.setFrom(FROM_EMAIL_ADDRESS);
        email.setSubject(subject);
        email.setMsg(body);
        email.addTo(recipient);
        email.send();
    }
}
