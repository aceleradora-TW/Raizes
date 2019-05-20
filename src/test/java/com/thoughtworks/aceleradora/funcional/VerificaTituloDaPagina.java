package com.thoughtworks.aceleradora.funcional;

import org.aspectj.apache.bcel.classfile.Utility;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificaTituloDaPagina {
    private static WebDriver driver = new ChromeDriver();


    public String getUrl(){
        final String paginaInicial="https://raizes-producao.herokuapp.com/";
        return paginaInicial;
    }


    @Test
    public void VerificaTituloAtualDaPagina(){
        driver.navigate().to(getUrl());
        String expectativaTituloDaPagina = "Aceleradora Ágil - Esqueleto Ambulante";
        String tituloAtualDaPagina=driver.getTitle();
        String tituloXpath = "/html/body/section/div/div/h1";
        driver.manage().window().maximize();
        System.out.println("Título atual da página do projeto: " + tituloAtualDaPagina);
        Assert.assertEquals("Teste passou", expectativaTituloDaPagina, tituloAtualDaPagina);
        Utilitario.waitForElementInDOM(driver, tituloXpath, 10);
        driver.close();
        driver.quit();
    }
}
