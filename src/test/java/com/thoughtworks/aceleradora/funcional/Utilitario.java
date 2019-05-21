package com.thoughtworks.aceleradora.funcional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilitario {
    public static void waitForElementInDOM(WebDriver driver, String identificadorElemento,
                                           long tempoDeEsperaEmSegundos)
    {
        WebDriverWait wait = new WebDriverWait(driver, tempoDeEsperaEmSegundos);
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    (identificadorElemento)));
        }
        catch(NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }

}
