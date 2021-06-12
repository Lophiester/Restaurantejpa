package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    //Texto plano
    void sendConfirmationEmailFromPedido(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    //versao Html
    void sendOrderConfirmationHtmlEmail(Pedido obj);
    void sendHtmlEmail(MimeMessage msg);

}
