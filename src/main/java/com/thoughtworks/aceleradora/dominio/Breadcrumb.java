package com.thoughtworks.aceleradora.dominio;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

@Component
@Scope(value = SCOPE_REQUEST)
public class Breadcrumb {

    private List<Pagina> paginas = new ArrayList<>();

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public Breadcrumb pagina(String titulo, String url) {
        paginas.add(new Pagina(titulo, url));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Breadcrumb that = (Breadcrumb) o;
        return Objects.equals(paginas, that.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paginas);
    }

    public String toString() {
        return paginas.stream().map(Pagina::toString).collect(joining(" > "));
    }
}
