package com.thoughtworks.aceleradora.dominio.componentes;

import com.thoughtworks.aceleradora.dominio.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EmailComponente {

    private JavaMailSender mailSender;
    private String email;

    public EmailComponente(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notificaProdutor(Pedido pedido) {
        SimpleMailMessage mensagem = new SimpleMailMessage();

//        pedido.getPedidosProdutosProdutores().forEach(pp -> {
//            pp.getProdutoProdutor().getProdutor().getEmail();
//        });

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
                    "- Telefone: " + pedido.getCliente().getContato() + "\n" +
                    "- PRODUTORES: "  + emailProdutores + "\n"
       );

        mensagem.setFrom("raizes.agil@gmail.com");
        mensagem.setTo("raizes.agil@gmail.com");

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

