package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public abstract class AbstractMailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendConfirmationEmailFromPedido(Pedido obj) {
        SimpleMailMessage smm = PrepareSimpleMailServiceFromPedido(obj);
        sendEmail(smm);
    }

    protected SimpleMailMessage PrepareSimpleMailServiceFromPedido(Pedido obj) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(obj.getCliente().getEmail());
        smm.setFrom(sender);
        smm.setSubject("Pedido confirmado! cod: " + obj.getId());
        smm.setSentDate(new Date(System.currentTimeMillis()));
        smm.setText(obj.toString());
        return smm;
    }


    protected String htmlFromTemplatePedido(Pedido obj) {
        Context context = new Context();
        context.setVariable("pedido", obj);
        return templateEngine.process("email/confirmacaoPedido", context);

    }

    @Override
    public void sendOrderConfirmationHtmlEmail(Pedido obj) {
        try {
            MimeMessage message = prepareMimeMessageFromPedido(obj);
            sendHtmlEmail(message);
        } catch (MessagingException e) {
            sendConfirmationEmailFromPedido(obj);
        }
    }

    protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(obj.getCliente().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Pedido confirmado! cod: " + obj.getId());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplatePedido(obj), true);
        return mimeMessage;
    }

}
