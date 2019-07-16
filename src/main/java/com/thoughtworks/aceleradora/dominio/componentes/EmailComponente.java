package com.thoughtworks.aceleradora.dominio.componentes;

import com.thoughtworks.aceleradora.dominio.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailComponente {

    private JavaMailSender mailSender;

    public EmailComponente(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notificaProdutor(Pedido pedido) {

        for (PedidoProdutoProdutor pedidoProdutoProdutor : pedido.getPedidosProdutosProdutores()) {
            SimpleMailMessage mensagem = new SimpleMailMessage();

            String emailProdutor = pedidoProdutoProdutor.getProdutoProdutor().getProdutor().getEmail();

            mensagem.setSubject("Raízes - Novo Pedido recebido!");

            mensagem.setText("Novo pedido recebido!\n" +
                    "\n" +
                    "- Nome: " + pedidoProdutoProdutor.getProdutoProdutor().getProdutor().getNome() + "\n" +
                    "\n ========================== \n" + "\n" +
                    " Dados da solicitante: " + "\n" +
                    "- Nome: " + pedido.getCliente().getNome() + "\n" +
                    "- E-mail: " + pedido.getCliente().getEmail() + "\n" +
                    "- Telefone: " + pedido.getCliente().getContato() + "\n" +
                    "\n ========================== \n" + "\n" +
                    " Dados do pedido: " + "\n" +
                    "- Nome: " +  "\n" +
                    "- E-mail: " + "\n" +
                    "- Telefone: " + "\n"

            );

            mensagem.setFrom("raizes.agil@gmail.com");
            mensagem.setTo(emailProdutor);

            try {
                mailSender.send(mensagem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

