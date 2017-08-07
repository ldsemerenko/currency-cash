package currencyСash.service;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    @Autowired
    private SessionService session;

    public void sendLetter(@NotNull String receiver, @NotNull String tittle, @NotNull String text) {
        System.out.println(session.account + session.password + "--------------------------------------------------------");

        try {
            Message message = new MimeMessage(session.getSession());
//            message.setFrom(new InternetAddress(account));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject(tittle);
            message.setText(text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}