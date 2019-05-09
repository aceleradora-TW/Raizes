package com.thoughtworks.aceleradora.dominio;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Breadcrumb {
    private List<String> items = new ArrayList<>();

    public Breadcrumb(List<String> items) {
        this.items = items;
    }

    public Breadcrumb() {}

    public List<String> get() {
        return items;
    }

    public void add(String item) {
        items.add(item);
    }
    public void remove(String item) {
        if (items.contains(item))
            items.remove(item);
    }

    private void save(HttpSession sessao) {
        if (sessao == null) return;
    }
}
