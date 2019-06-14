package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Breadcrumb;
import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.dominio.ProdutoProdutor;
import com.thoughtworks.aceleradora.dominio.TipoDeCultivo;
import com.thoughtworks.aceleradora.dominio.excecoes.ProdutoNaoSalvoExcecao;
import com.thoughtworks.aceleradora.servicos.CategoriaServico;
import com.thoughtworks.aceleradora.servicos.ProdutoProdutorServico;
import com.thoughtworks.aceleradora.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.function.Consumer;

@Controller
@RequestMapping("/produtos")
public class ProdutoControlador {

    private ProdutoServico produtoServico;
    private CategoriaServico categoriaServico;
    private ProdutoProdutorServico produtoProdutorServico;

    private final Consumer<Breadcrumb> partesComunsDoBreadCrumb = breadcrumb -> breadcrumb
            .pagina("Página inicial", "/");

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

        return "produto/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarProduto(Produto produto, Model modelo, Breadcrumb breadcrumb, RedirectAttributes redirecionamentoDeAtributos) {
        breadcrumb
                .aproveitar(partesComunsDoBreadCrumb)
                .pagina("Produtos", "/produtos")
                .pagina("Cadastro", "/produtos/cadastro");
        try {
            produto.setNome(produto.getNome().trim());
            produtoServico.salvar(produto);

            String mensagem = "Seu produto foi cadastrado com sucesso!";
            modelo.addAttribute("mensagemSalvoComSucesso", mensagem);
        } catch (ProdutoNaoSalvoExcecao e) {
            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());

            return "redirect:/produtos/cadastro";
        }

        return "redirect:/produtos/cadastro";
    }

//    @GetMapping("/{id}/editar")
//    public String editarProduto(Breadcrumb breadcrumb, Model modelo, @PathVariable Long id) {
//        breadcrumb
//                .aproveitar(partesComunsDoBreadCrumb)
//                .pagina("Editar Produto", "/produtos/editar-produto");
//
//
//        ProdutoProdutor produtoProdutor = produtoProdutorServico.encontraUm(id);
//
//        modelo.addAttribute("produtoProdutor", produtoProdutor);
//
//        return "produto/editar";
//    }
//
//    @PostMapping("/{id}/editar")
//    public String salvarProduto(
//            ProdutoProdutor produtoProdutor, Breadcrumb breadcrumb, Model modelo, @PathVariable Long id, RedirectAttributes redirecionamentoDeAtributos
//    ) {
//
//        try {
//
//            System.out.println(">>>>>>>>>>>> " + produtoProdutor.getTipoDeCultivo());
//
//            produtoProdutorServico.salvar(produtoProdutor);
//
//            String mensagem = "Seu produto foi cadastrado com sucesso!";
//            modelo.addAttribute("mensagemSalvoComSucesso", mensagem);
//        } catch (ProdutoNaoSalvoExcecao e) {
//            redirecionamentoDeAtributos.addFlashAttribute("mensagem", e.getMessage());
//
//            return "redirect:/produto/editar";
//        }
//
//        return "redirect:/produto/editar";
//    }
}
