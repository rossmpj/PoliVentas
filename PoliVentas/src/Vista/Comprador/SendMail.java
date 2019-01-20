package Vista.Comprador;

import Auxiliares.MensajesAcciones;
import Vista.Principal.Vista;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rosy
 */
public class SendMail {
    private final static String GMAIL_HOST = "smtp.gmail.com";
    public static String Username = "poliventasespol@gmail.com";
    public static String PassWord = "srxkPVpar1";

    public void SendMail(String To, String msg) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", GMAIL_HOST);
        props.setProperty("mail.user", Username);
        props.setProperty("mail.password", PassWord);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setText("Se ha realizado el pago del siguiente producto:\n"+msg);
            message.setSubject("Realizar entrega de producto");
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(To) });
            Transport t = session.getTransport("smtp");
            t.connect(GMAIL_HOST,Username, PassWord);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            System.out.println("sended");
            MensajesAcciones.NotificarVendedor();
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
            MensajesAcciones.NotificarVendedorFailed();
        }
    }    
}