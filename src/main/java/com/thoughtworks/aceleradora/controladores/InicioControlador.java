package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Cliente;
import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.servicos.ClienteServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

@Controller
public class InicioControlador {
    private ProdutorServico produtorServico;
    private ClienteServico clienteServico;

    @Autowired
    public InicioControlador(ProdutorServico produtorServico, ClienteServico clienteServico) {
        this.produtorServico = produtorServico;
        this.clienteServico = clienteServico;
    }

    @GetMapping("/")
    public String renderizaPaginaInicial(Breadcrumb breadcrumb) {
        breadcrumb
                .pagina("Página Inicial", "/");

        return "inicio";
    }

    @GetMapping("/cria-produtor")
    public ResponseEntity criaProdutor(){
        Produtor produtor = new Produtor("raizes@teste.com", "senha", "Raizes", "Contato", null, true);

        produtorServico.salvaProdutor(produtor);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cria-cliente")
    public ResponseEntity criaCliente(){
        Cliente cliente = new Cliente("raizes@teste.com", "senha", "Raizes", "Contato", null, Collections.emptyList());

        clienteServico.salvaCliente(cliente);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientes/{id}")
    @ResponseBody
    public Cliente pegaClientePorId (@PathVariable Long id){
        return clienteServico.buscaPorId(id);
    }


    @GetMapping("/produtores/{id}")
    @ResponseBody
    public Produtor pegaProdutorPorId (@PathVariable Long id){
        return produtorServico.buscaPorId(id);
    }

}
