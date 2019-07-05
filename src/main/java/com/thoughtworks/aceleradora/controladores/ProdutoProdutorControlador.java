package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.TipoDeCultivo;
import com.thoughtworks.aceleradora.dominio.UnidadeMedida;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoEncontradoExcecao;
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

import javax.validation.Valid;
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
            .pagina("Página Inicial", "/");

    @Autowired
    public ProdutoProdutorControlador(ProdutoServico produtoServico, CategoriaServico categoriaServico, ProdutoProdutorServico produtoProdutorServico, ProdutorServico produtorServico) {
        this.produtoServico = produtoServico;
        this.categoriaServico = categoriaServico;
        this.produtoProdutorServico = produtoProdutorServico;
        this.produtorServico = produtorServico;
    }


    @GetMapping("/cadastro")
    public String cadastrarProduto(Model modelo, Breadcrumb breadcrumb, ProdutoProdutor produtoProdutor) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Estoque", "/produtos/visualizar-estoque")
                .pagina("Cadastro", "/produtos/cadastro");


        ProdutoProdutor produtoProdutorComProdutorHardocoded = new ProdutoProdutor();
        produtoProdutorComProdutorHardocoded.setProdutor(produtorServico.encontraUm(1L));

        modelo.addAttribute("categorias", categoriaServico.pegarCategorias());
        modelo.addAttribute("cultivos", Arrays.asList(TipoDeCultivo.values()));
        modelo.addAttribute("produtos", produtoServico.pegarTodosPorOrdemAlfabetica());
        modelo.addAttribute("medidas", Arrays.asList(UnidadeMedida.values()));
        modelo.addAttribute("produtoProdutor", produtoProdutorComProdutorHardocoded);

        return "produto/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarProdutoProdutor(@Valid ProdutoProdutor produtoProdutor,
                                        BindingResult resultadoValidacao,
                                        Breadcrumb breadcrumb,
                                        RedirectAttributes redirecionamentoDeAtributos,
                                        Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");

        if (resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());
            redirecionamentoDeAtributos.addFlashAttribute("erros", resultadoValidacao.getAllErrors());

            return "redirect:/produtos/cadastro";
        }

        produtoProdutorServico.salvar(produtoProdutor);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");

        return "redirect:/produtos/visualizar-estoque";
    }


    @GetMapping("/{id}/editar")
    public String editarProduto(Breadcrumb breadcrumb, Model modelo, @PathVariable Long id, RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Atualizar Dados do Produto", "/produtos/editar-produto");

        try {
            ProdutoProdutor produtoprodutor = produtoProdutorServico.encontraUm(id);

            modelo.addAttribute("cultivos", Arrays.asList(TipoDeCultivo.values()));
            produtoprodutor.setPreco(produtoprodutor.getPreco());
            modelo.addAttribute("produtoProdutor", produtoprodutor);

        } catch (ProdutoNaoEncontradoExcecao e) {
            redirecionamentoDeAtributos.addAttribute("mensagem", e.getMessage());

            return "produto/editar";

        }

        return "produto/editar";
    }

    @PostMapping("/{id}/editar")
    public String salvarProduto(@Valid ProdutoProdutor produtoProdutor,
                                BindingResult resultadoValidacao,
                                Breadcrumb breadcrumb,
                                Model modelo,
                                RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Atualizar Dados do Produto", "/produtos/editar-produto");

        if (resultadoValidacao.hasErrors()) {
            modelo.addAttribute("erros", resultadoValidacao.getAllErrors());

            redirecionamentoDeAtributos.addFlashAttribute("erros", resultadoValidacao.getAllErrors());
            return "redirect:/produtos/{id}/editar";
        }
        produtoProdutorServico.salvar(produtoProdutor);

        redirecionamentoDeAtributos.addFlashAttribute("mensagem", "Produto atualizado com sucesso!");

        return "redirect:/produtos/visualizar-estoque";
    }

    @GetMapping("/visualizar-estoque")
    public String estoque(Breadcrumb breadcrumb, Model modelo) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Estoque", "produto/visualizar-estoque");

        modelo.addAttribute("produtosProdutor", produtoProdutorServico.pegarProdutos());

        return "produto/visualizar-estoque";
    }
}