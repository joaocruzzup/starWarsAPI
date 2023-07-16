package org.example.controller;

import org.example.service.InventarioService;

public class InventarioController {
    private InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public void visualizarInventario(Long id){
        inventarioService.visualizarInventario(id);
    }

    public void adicionadItemInventario(Long idRebelde, Long idItem){
        inventarioService.adicionarItemInventario(idRebelde, idItem);
    }
}
