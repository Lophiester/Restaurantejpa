package com.lophiester.Restaurante.services;

import com.lophiester.Restaurante.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractMailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendConfirmationEmailFromPedido(Pedido obj) {
        SimpleMailMessage smm= PrepareSimpleMailServiceFromPedido(obj);
        sendEmail(smm);
    }

    protected  SimpleMailMessage PrepareSimpleMailServiceFromPedido(Pedido obj){
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(obj.getCliente().getEmail());
        smm.setFrom(sender);
        smm.setSubject("Pedido confirmado com sucesso! cod: " + obj.getId());
        smm.setText(obj.toString());
        smm.setSentDate(new Date(System.currentTimeMillis()));
        return smm;
    };
}
