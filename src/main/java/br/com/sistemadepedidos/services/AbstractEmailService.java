/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Pedido;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Grazziano Fagundes
 */
public abstract class AbstractEmailService implements EmailService {
    
    @Value("${default.sender}")
    private String sender;
    
    @Override
    public void sendOrderConfirmationEmail(Pedido obj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
        sendEmail(sm);
    }
    
    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getCliente().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido confirmado! Código: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        
        return sm;
    }
}
