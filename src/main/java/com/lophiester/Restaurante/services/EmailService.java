package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendConfirmationEmailFromPedido(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

}
