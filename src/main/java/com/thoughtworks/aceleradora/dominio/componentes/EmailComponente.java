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

            mensagem.setSubject("Novo Pedido recebido!");

            mensagem.setText("Raizes - Novo pedido recebido!\n" +
                    "\n" +
                    "- Nome do Produtor: " + pedidoProdutoProdutor.getProdutoProdutor().getProdutor().getNome() + "\n" +
                    "\n =========== Dados do Pedido =============== \n" + "\n" +
                    "- Data do Pedido: " + pedido.getCriadoEm().toString() + "\n" +
                    "- Produto solicitado: " + pedidoProdutoProdutor.getProdutoProdutor().getProduto().getNome() + "\n" +
                    "- Quantidade solicitada do produto: " + pedidoProdutoProdutor.getQuantidadePedido() +
                    "/ " + pedidoProdutoProdutor.getProdutoProdutor().getProduto().getUnidadeMedida().getCodigo() + "\n" +
                    "- Total do pedido: " + "PEGAR DA MAYARA E DA FRAN" + "\n" +
                    "\n =========== Dados do Solicitante =============== \n" + "\n" +
                    "- Nome: " + pedido.getCliente().getNome() + "\n" +
                    "- E-mail: " + pedido.getCliente().getEmail() + "\n" +
                    "- Telefone: " + pedido.getCliente().getContato() + "\n" +
                    "- Endereço: " + "\n" +
                    "\t- Cidade: " + pedido.getCliente().getEndereco().getCidade().getNome() + "\n" +
                    "\t- Bairro: " + pedido.getCliente().getEndereco().getBairro() + "\n" +
                    "\t- Endereço: " + pedido.getCliente().getEndereco().getRua() + ", " +
                    pedido.getCliente().getEndereco().getComplemento()  +
                    " Nº: " + pedido.getCliente().getEndereco().getNumero()
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


