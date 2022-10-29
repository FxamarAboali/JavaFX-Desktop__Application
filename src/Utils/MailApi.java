/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.util.Properties;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class MailApi {  
 public static void sendMail(String recepient,String msg) throws Exception {
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
//        String myAccountEmail = "titanscrum6@gmail.com";
//        //Your gmail password
//        String password = "123456789aZ";
  String myAccountEmail = "titanscrum6@gmail.com";
        //Your gmail password
        String password = "123456789aZ";
        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient,msg);

        //Send mail
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String msg) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Your Password ");
            message.setContent("<h3>password: </h3><p>"+msg+"</p>", "text/html");
            return message;
        } catch (Exception ex) {
        }
        return null;
    }

}