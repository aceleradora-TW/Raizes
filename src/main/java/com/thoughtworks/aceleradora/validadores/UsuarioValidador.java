package com.thoughtworks.aceleradora.validadores;


import com.thoughtworks.aceleradora.dominio.Usuario;
import com.thoughtworks.aceleradora.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.equals(clazz);
    }

    @Override
    public void validate(Object objeto, Errors erros) {
        Usuario usuario = (Usuario) objeto;

        if(usuarioRepositorio.findByEmail(usuario.getEmail()) != null) {
            erros.rejectValue("usuario", "Usuario.usuarioForm.usuarioDuplicado");
        }
    }
}