package com.thoughtworks.aceleradora.dominio.componentes;

import com.thoughtworks.aceleradora.dominio.Pedido;
import com.thoughtworks.aceleradora.dominio.PedidoProdutoProdutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailComponente {

    private JavaMailSender mailSender;
//    private String email = "aceleradora15@gmail.com";

    public EmailComponente(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notificaProdutor() {
        SimpleMailMessage mensagem = new SimpleMailMessage();

//        pedido.getPedidosProdutosProdutores().forEach(pp -> {
//            pp.getProdutoProdutor().getProdutor().getEmail();
//        });

        mensagem.setSubject("Novo Pedido recebido!");

        mensagem.setText("Novo pedido recebido!\n" + "\n"
//                            +
//                    "- Raízes: " + solicitacao.getNome() + "\n" +
//                    "- Data de Nascimento: " + solicitacao.getDataNascimento() + "\n" +
//                    "\n ========================== \n" + "\n" +
//                    " Dados da solicitante: " + "\n" +
//                    "- Nome: " + solicitacao.getNomeSolicitante() + "\n" +
//                    "- E-mail: " + solicitacao.getEmail() + "\n" +
//                    "- Hospital de Referência: " + solicitacao.getHospitalReferencia() + "\n" +
//                    "- Telefone: " + solicitacao.getTelefoneSolicitante()
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

