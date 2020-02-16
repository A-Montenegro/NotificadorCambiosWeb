package NotificadorCambiosWeb;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioEmails {

    public static void enviarEmail(String url) {
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {    
        	protected PasswordAuthentication getPasswordAuthentication() {
        	String email = CreadorListaObjetivos.propiedadesConfiguracion.getProperty("email");
        	String password = CreadorListaObjetivos.propiedadesConfiguracion.getProperty("password");
        	return new PasswordAuthentication(email,password); 
         }    
        });    
        try {      
	         MimeMessage message = new MimeMessage(session);    
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress("alberto.crk@gmail.com"));    
	         message.setSubject("Coincidencia positiva detectada.");    
	         message.setText("Se ha detectado una coincidencia positiva en las busquedas automatizadas.\n" + url);  
	         Transport.send(message);    
        } catch(MessagingException e) {
        	 throw new RuntimeException(e);}    
        }
    
    }