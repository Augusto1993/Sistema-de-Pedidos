/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.services;

import org.springframework.mail.SimpleMailMessage;
import br.com.sistemadepedidos.domain.Pedido;

/**
 *
 * @author Grazziano Fagundes
 */
public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}
