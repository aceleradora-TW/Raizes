package com.thoughtworks.aceleradora.dominio.componentes;

import com.thoughtworks.aceleradora.dominio.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailComponente {

    private JavaMailSender mailSender;
    private String email;

    public EmailComponente(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notificaProdutor(Pedido pedido) {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        List<String> emailProdutores = new ArrayList<>();

        for (PedidoProdutoProdutor p: pedido.getPedidosProdutosProdutores()) {
            emailProdutores.add(p.getProdutoProdutor().getProdutor().getEmail());
        }

        email = pedido.getCliente().getEmail();

        mensagem.setSubject("Novo Pedido recebido!");

        mensagem.setText("Novo pedido recebido!\n" + "\n"
                +
                "- Raízes: " + "\n" +
                "\n ========================== \n" + "\n" +
                " Dados da solicitante: " + "\n" +
                "- Nome: " + pedido.getCliente().getNome() + "\n" +
                "- E-mail: " + email + "\n" +
                "- Telefone: " + pedido.getCliente().getContato() + "\n"
        );

        mensagem.setFrom("raizes.agil@gmail.com");
        mensagem.setTo(pedido
                .getPedidosProdutosProdutores()
                .stream()
                .map(pedidoProdutoProdutor -> pedidoProdutoProdutor.getProdutoProdutor().getProdutor().getEmail())
                .collect(Collectors.joining(",")));

        try {
            mailSender.send(mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }








//    public void notificaCliente(PedidoProdutoProdutor pedido) {
//        SimpleMailMessage mensagem = new SimpleMailMessage();

//            mensagem.setSubject("Status de uma solicitação foi alterado!");
//
//            mensagem.setText("Status de uma solicitação de: "+ solicitacao.getNome() +
//                    " foi alterado para: " + solicitacao.getStatus() + "!");
//
//            mensagem.setFrom(this.email);
//            mensagem.setTo(solicitacao.getEmail());
//
//            try {
//                mailSender.send(mensagem);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

