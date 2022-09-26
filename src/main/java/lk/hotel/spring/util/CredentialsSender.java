package lk.hotel.spring.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class CredentialsSender {
    public void SendCredentials(String username, String password, String receipt){
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

        String messageBody = password + "-" +username;

        Message message = prepareMessage(session, myAccountEmail, receipt, messageBody);
        try {
            Transport.send(message);
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String msgBody) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
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
