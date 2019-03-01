package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.Pessoa;
import com.thoughtworks.aceleradora.dominio.PessoaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaControllerTest {

    @Mock
    private PessoaRepository repository;

    private PessoaController controller;

    @Before
    public void setUp() {
        controller = new PessoaController(repository);
    }

    @Test
    public void renderizaFormularioDeCadastro() {
        assertThat(controller.formularioCadastro(), is("pessoa/cadastro"));
    }

    @Test
    public void renderizaListaDePessoasComTodasAsPessoasDoBanco() {
        List<Pessoa> pessoasCadastradas = asList(
                new Pessoa("Policarpo", "Quaresma"),
                new Pessoa("Jean", "Bartik"));
        Model model = mock(Model.class);
        when(repository.findAll()).thenReturn(pessoasCadastradas);

        String paginaRenderizada = controller.lista(model);

        verify(model).addAttribute("pessoas", pessoasCadastradas);
        assertThat(paginaRenderizada, is("pessoa/lista"));

    }

    @Test
    public void salvaDadosDaPessoaCadastradaERedirecionaParaLista() {

        Pessoa pessoaCadastrada = new Pessoa("Lima", "Barreto");

        String paginaRenderizada = controller.salvaCadastro(pessoaCadastrada);

        verify(repository).save(pessoaCadastrada);
        assertThat(paginaRenderizada, is("redirect:lista"));
    }
}