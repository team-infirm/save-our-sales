package com.sagepay.sos.resources;

import com.sagepay.sos.db.CancellationsDAO;
import com.sagepay.sos.gateway.AESCryptoUtils;
import com.sagepay.sos.gateway.FormRegistrationGenerator;
import com.sagepay.sos.notifications.EmailSender;
import com.sagepay.sos.core.ChaserRequest;
import com.sagepay.sos.core.Cancellation;
import org.apache.commons.mail.EmailException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/chasers")
@Produces (MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChaserResource {

    private final CancellationsDAO cancellationsDao;

    public ChaserResource(CancellationsDAO cancellationsDAO){
        this.cancellationsDao = cancellationsDAO;
    }

    @POST
    public void sendChaser(ChaserRequest chaserRequest){
        for (String id : chaserRequest.getTransactionIds()){
            System.out.println("Sending email for cancellation with an id of " + id);
            try{
                Cancellation cancellation = cancellationsDao.getCancellation(id);

                String registration = new FormRegistrationGenerator(cancellation.getVendorName(), cancellation.getTransactionValue().toString()).
                        generateRegistrationString(randomNumber());
                String cryptString = AESCryptoUtils.encryptToSagepayStandard(registration, "4X4CauKt56wYcM2M");

                String registrationLink = FormRegistrationGenerator.createRegistrationLink(cryptString, cancellation.getVendorName());

                EmailSender.sendEmail(cancellation.getCustomerEmail(),"Hi, We noticed you didn't complete your purchase through our on-line store. We hope you didn't encounter difficulties, if you'd like to try again, click the link below. As a gesture of goodwill, we've applied a discount to your original order and the new amount is [XX.XX GBP]. Many Thanks www.webstore.com -> " + registrationLink, "Test");
            } catch (EmailException e) {
                System.out.println("Failed to send email." + e.getMessage() );
                System.out.println(e.getStackTrace());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String randomNumber() {
        Random randomGenerator = new Random();
        return Integer.toString(randomGenerator.nextInt(100000));
    }
}
