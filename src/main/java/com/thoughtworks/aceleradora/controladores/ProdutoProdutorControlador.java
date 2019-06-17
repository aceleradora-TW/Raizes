package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoProdutorServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.function.Consumer;

@Controller
@RequestMapping("/produtos")
public class ProdutoProdutorControlador {

    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;
    private ProdutoProdutorServico produtoProdutorServico;
    private ProdutorServico produtorServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página inicial", "/");

    @Autowired
    public ProdutoProdutorControlador(ProdutoServico produtoServico,
                                      CategoriaServico categoriaServico,
                                      ProdutoProdutorServico produtoProdutorServico,
                                      ProdutorServico produtorServico) {
        this.produtoServico = produtoServico;
        this.categoriaServico = categoriaServico;
        this.produtoProdutorServico = produtoProdutorServico;
        this.produtorServico = produtorServico;
    }


    @GetMapping("/cadastro")
    public String cadastrarProduto(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        ProdutoProdutor produtoProdutorComProdutorHardocoded = new ProdutoProdutor();
        produtoProdutorComProdutorHardocoded.setProdutor(produtorServico.encontraUm(1L));

        modelo.addAttribute("categorias", categoriaServico.pegarCategorias());
        modelo.addAttribute("cultivos", Arrays.asList(TipoDeCultivo.values()));
        modelo.addAttribute("produtos", produtoServico.pegarTodos());
        modelo.addAttribute("produtoProdutor",new ProdutoProdutor());
        modelo.addAttribute("medidas", Arrays.asList(UnidadeMedida.values()));
        modelo.addAttribute("produtoProdutor", produtoProdutorComProdutorHardocoded);

        return "produto/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarProdutoProdutor(ProdutoProdutor produtoProdutor,
                                        Breadcrumb breadcrumb,
                                        RedirectAttributes redirecionamentoDeAtributos,
                                        Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        try {
            produtoProdutorServico.salvar(produtoProdutor);

            String mensagem = "Seu produto foi cadastrado com sucesso!";
            modelo.addAttribute("mensagemSalvoComSucesso", mensagem);
        } catch (ProdutoNaoSalvoExcecao e){
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/produtos/cadastro";
        }

        return "redirect:/produtos/cadastro";
    }

    @GetMapping("/{id}/editar")
    public String editarProduto(Breadcrumb breadcrumb, Model modelo, @PathVariable Long id) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Editar Produto", "/produtos/editar-produto");

        modelo.addAttribute("produtoProdutor", produtoProdutorServico.encontraUm(id));

        return "produto/editar";
    }

    @PostMapping("/{id}/editar")
    public String salvarProduto(ProdutoProdutor produtoProdutor, Breadcrumb breadcrumb, Model modelo, @PathVariable Long id, RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Editar Produto", "/produtos/editar-produto");

        try {
            produtoProdutorServico.salvar(produtoProdutor);

            redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Produto criado com sucesso!");

        } catch (ProdutoNaoSalvoExcecao e){
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/produtos/cadastro";
        }

        return "redirect:/produtos/cadastro";
    }
}