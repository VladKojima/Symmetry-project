package team.symmetry.ResumeBack.services;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    JavaMailSender sender;

    public void sendSimpleEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        sender.send(simpleMailMessage);
    }

    public void sendEmailWithAttachments(String toAddress, String subject, String message, Map<String, File> attachments)
            throws MessagingException {

        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);

        for (var entry : attachments.entrySet()) {
            messageHelper.addAttachment(entry.getKey(), entry.getValue());
        }

        sender.send(mimeMessage);
    }
}
