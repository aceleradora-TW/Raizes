package com.thoughtworks.aceleradora.login.configuracao;

import com.thoughtworks.aceleradora.login.dominio.TipoDeUsuario;
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

    public AuthSuccessHandler() {
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    public AuthSuccessHandler(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SimpleGrantedAuthority tipousuario = (SimpleGrantedAuthority) authentication.getAuthorities().stream().findFirst().get();

        if(tipousuario.getAuthority().equals(TipoDeUsuario.PRODUTOR.getNome())) {
            this.redirectStrategy.sendRedirect(request, response, "/bemvindo");

        } else if(tipousuario.getAuthority().equals(TipoDeUsuario.RESTAURANTEIRO.getNome())) {
            this.redirectStrategy.sendRedirect(request, response, "/solicitacao/hospital/lista");

        } else {
            this.redirectStrategy.sendRedirect(request, response, "/bemvindo");
        }
    }

}
