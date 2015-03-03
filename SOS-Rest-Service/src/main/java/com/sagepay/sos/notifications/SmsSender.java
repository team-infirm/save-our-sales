package com.sagepay.sos.notifications;

import com.clockworksms.ClockWorkSmsService;
import com.clockworksms.ClockworkException;
import com.clockworksms.ClockworkSmsResult;
import com.clockworksms.SMS;

public class SmsSender {

    private static String SMS_API_KEY = "9ba976a2a87a01d2ea4d76238f7c906a1a19966d";

    public static void sendSMS(String recipient, String body) {
        try {
            ClockWorkSmsService clockWorkSmsService = new ClockWorkSmsService(SMS_API_KEY);
            SMS sms = new SMS(recipient, body);
            ClockworkSmsResult result = clockWorkSmsService.send(sms);

            if (result.isSuccess()) {
                System.out.println("Sent with ID: " + result.getId());
            } else {
                System.out.println("Error: " + result.getErrorMessage());
            }
        } catch (ClockworkException e) {
            e.printStackTrace();
        }
    }
}
