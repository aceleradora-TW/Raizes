package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.*;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import com.thoughtworks.aceleradora.servicos.ProdutorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.thoughtworks.aceleradora.servicos.ProdutoProdutorServico;

import java.util.Arrays;
import java.util.function.Consumer;

@Controller
@RequestMapping("/produtos")
public class ProdutoControlador {

    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;
    private ProdutoProdutorServico produtoProdutorServico;
    private ProdutorServico produtorServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Início", "/");

    @Autowired
    public ProdutoControlador(ProdutoServico produtoServico, CategoriaServico categoriaServico, ProdutoProdutorServico produtoProdutorServico) {
        this.produtoServico = produtoServico;
        this.categoriaServico = categoriaServico;
        this.produtoProdutorServico = produtoProdutorServico;
    }

    @GetMapping("/cadastro")
    public String cadastrarProduto(Model modelo, Breadcrumb breadcrumb) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        modelo.addAttribute("categorias", categoriaServico.pegarCategorias());
        modelo.addAttribute("cultivos", Arrays.asList(TipoDeCultivo.values()));
        modelo.addAttribute("produtos", produtoServico.pegarTodos());
        modelo.addAttribute("medida", Arrays.asList(UnidadeMedida.values()))

        return "produto/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarProduto (ProdutoProdutor produtoProdutor,Produtor produtor, Produto produto, Breadcrumb breadcrumb, RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");
        try {
//            produtoProdutor.setProdutor(produtorServico.encontraUm( 1L));
//            produtoProdutor.setProduto(produtoServico.encontraUmNome(produto.getNome()).get());
//            produtoProdutor.setPreco(produtoProdutor.getPreco());
//            produtoProdutor.setQuantidadeEstoque(produtoProdutor.getQuantidadeEstoque());
//            produtoProdutor.setTipoDeCultivo(produtoProdutor.getTipoDeCultivo());

            produtoProdutorServico.salvar(produtoProdutor);

            redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Produto criado com sucesso!");
        } catch (ProdutoNaoSalvoExcecao e){
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/produtos/cadastro";
        }

        return "redirect:/produtos/";
    }
}