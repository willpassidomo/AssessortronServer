/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assesortron;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailService.Attachment;
import com.google.appengine.api.mail.MailService.Message;
import com.google.appengine.api.mail.MailServiceFactory;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author willpassidomo
 */
public class Emailer {
    private static final String from = "willpassidomo@gmail.com";    
    private static final String SUBJECT = "Assesortron site data";
    private static final String MESSAGE_BODY = "attached is an excel data sheet"
            + "with entries for the requested project.";
                
    public boolean sendDefaultMail(String to, String userName, byte[] file, String fileName) {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        
        try {
//            Message message = new MimeMessage(session);
//            Multipart multipart = new MimeMultipart();
//            BodyPart messageAttachement = new MimeBodyPart();

            MailService service = MailServiceFactory.getMailService();
            Message message = new Message();

            message.setSender(from);
            message.setTo(to);
            message.setSubject(SUBJECT);
            message.setTextBody(MESSAGE_BODY);
            
            Attachment attachment = new Attachment(fileName, file);
            message.setAttachments(attachment);
            service.send(message);
//            messageAttachement.setFileName(fileName);
//            messageAttachement.setContent(file, "application/vnd.ms-excel"); 
//            multipart.addBodyPart(messageAttachement);
            
//            message.setA(multipart);
            
//            Transport.send(message);
            
            return true;
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }         
    }
}
