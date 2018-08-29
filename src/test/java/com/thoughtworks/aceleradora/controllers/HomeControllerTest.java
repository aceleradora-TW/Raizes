package com.thoughtworks.aceleradora.controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void returns_index() {
        HomeController homeController = new HomeController();

        assertEquals("index", homeController.index());
    }
}