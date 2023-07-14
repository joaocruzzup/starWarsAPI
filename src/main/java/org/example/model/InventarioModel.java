package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    private Long id;
    private List<ItemModel> itens;

    public InventarioModel(){
        itens = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }
}
