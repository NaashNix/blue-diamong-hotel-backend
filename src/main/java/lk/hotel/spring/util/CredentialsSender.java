package lk.hotel.spring.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class CredentialsSender {
    public void SendCredentials(String username, String password, String receipt, String firstName){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "sanasabankgalthude@gmail.com";
        String accountPassword = "lvkhhgbokphchhye";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, accountPassword);
            }
        });

        String messageBody = ("<h4>Dear "+firstName +", Welcome to Blue Diamond Hotel</h4>" +
                "<p>Use below credentials to login to your account. Don't share your credentials with anyone." +
                "If you want any assistance call us on : +(94)702053777</p> <br>" +
                "<code>Username : <b>"+username+"</b></code><br>" +
                "<code>Password : <b>"+password+"</b></code><br>" +
                "<i>Thank You! <br> Blue Diamond Hotel Team</i>");

        Message message = prepareMessage(session, myAccountEmail, receipt, messageBody, firstName);
        try {
            Transport.send(message);
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String receipt, String msgBody, String firstName) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipt));
            message.setSubject("Welcome To Blue Diamond Hotel Chain");
            /*String htmlCode = "<h1> WE LOVE JAVA </h1> <br/> <h2><b>Next Line </b></h2>";*/
            message.setContent(msgBody, "text/html");
            return message;
        } catch (AddressException ex) {
            /*Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);*/
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
