package org.example.service;

import org.example.model.InventarioModel;
import org.example.model.ItemModel;

import java.util.List;

public class InventarioService {

    private InventarioModel inventario;

    public InventarioService(){
        inventario = new InventarioModel();
    }

    public void buscarInventario(Long idRebelde){

    }

    public void adicionarItemInventario(Long idRebelde, List<ItemModel> itens){
        inventario.setId(idRebelde);
        inventario.setItens(itens);
    }
}
