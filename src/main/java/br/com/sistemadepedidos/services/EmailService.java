package br.com.sistemadepedidos.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.sistemadepedidos.domain.Cliente;
import br.com.sistemadepedidos.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
