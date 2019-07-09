package com.thoughtworks.aceleradora.config;

import com.thoughtworks.aceleradora.dominio.TipoDeUsuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy;

    public AuthSuccessHandler(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public AuthSuccessHandler() {
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        SimpleGrantedAuthority tipoDeUsuario = (SimpleGrantedAuthority) authentication.getAuthorities().stream().findFirst().get();

        if (tipoDeUsuario.getAuthority().equals(TipoDeUsuario.PRODUTOR.getValor())) {
            this.redirectStrategy.sendRedirect(request, response, "/minhas-listas");

        } else if (tipoDeUsuario.getAuthority().equals(TipoDeUsuario.CLIENTE.getValor())) {
            this.redirectStrategy.sendRedirect(request, response, "/minhas-listas/criar");

        } else {
            this.redirectStrategy.sendRedirect(request, response, "/registrar");
        }
    }
}
