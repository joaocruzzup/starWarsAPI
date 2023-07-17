package org.example.controller;

import org.example.repository.IIventarioRepository;
import org.example.service.InventarioService;

public class InventarioController implements IIventarioRepository {
    private InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public void visualizarInventario(Long id){
        inventarioService.visualizarInventario(id);
    }


    public void adicionarItemInventario(Long idRebelde, Long idItem){
        inventarioService.adicionarItemInventario(idRebelde, idItem);
    }
}
