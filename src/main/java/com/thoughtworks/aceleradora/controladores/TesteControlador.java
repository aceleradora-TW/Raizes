package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Produtor;
import com.thoughtworks.aceleradora.servicos.ProdutorServico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teste")
public class TesteControlador {

    private ProdutorServico produtorServico;

    public TesteControlador(ProdutorServico produtorServico) {
        this.produtorServico = produtorServico;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Produtor mostra(@PathVariable("id") Long id){
        Produtor produtor = produtorServico.pegarTodos(1L).get();
        return produtor;
    }
}
