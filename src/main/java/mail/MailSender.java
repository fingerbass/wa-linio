package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {
    public static void sendReportHTML(String recipient, String htmlPath) throws Exception {
        Properties properties = new Properties();

        // Parámetros de autenticación al servidor de correo.
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String mailFrom = "djmeterbass@gmail.com";
        String password = "yesyel27/04/05";

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailFrom, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // Prepara contenido del mensaje y adjunta archivo html.
        Message message = prepareMessage(session, mailFrom, recipient);

        // Envía el correo
        if (message != null) {
            Transport.send(message);
        }
        System.out.println("Reporte enviado satisfactoriamente.");
    }

    private static Message prepareMessage(Session session, String mailFrom, String recepient) {
        try {
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(mailFrom));
            InternetAddress[] toAddresses = {new InternetAddress(recepient)};
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject("Reporte de ejecución LINIO");
            msg.setSentDate(new Date());

            // variable para contener las partes del correo (body y attachments)
            Multipart multipart = new MimeMultipart();

            // Creando la sección body del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<h3>Reporte de ejecuci&oacute;n Linio</h3><br><p>Se adjunta" +
                    " archivo HTML con el reporte de la ejecuci&oacute;n del caso de prueba automatizado " +
                    "para la web Linio.</p>", "text/html");
            multipart.addBodyPart(messageBodyPart);

            // Adjuntar el archivo HTML
            MimeBodyPart attachPart = new MimeBodyPart();
            String path = System.getProperty("user.dir") + "/reportes/html/index.html";

            try {
                attachPart.attachFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Adjuntar archivo
            multipart.addBodyPart(attachPart);

            msg.setContent(multipart);

            return msg;
        } catch (Exception ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
