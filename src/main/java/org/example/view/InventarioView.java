package org.example.view;

import org.example.controller.InventarioController;
import org.example.service.InventarioService;

import java.util.Scanner;

public class InventarioView {
    private InventarioController inventarioController;
    private Scanner sc;

    public InventarioView(){
        InventarioService inventarioService = new InventarioService();
        sc = new Scanner(System.in);
        inventarioController = new InventarioController(inventarioService);
    }

    public void imprimirVisualizarInventario(){
        System.out.println("Digite o id do Rebelde: ");
        Long idRebelde = sc.nextLong();
        sc.nextLine();
        inventarioController.visualizarInventario(idRebelde);
    }

    public void imprimirComprarItem(){
        System.out.println("Digite o id do Rebelde: ");
        Long idRebelde = sc.nextLong();
        System.out.println("Digite o id do Item: ");
        Long idItem = sc.nextLong();
        inventarioController.adicionadItemInventario(idRebelde, idItem);
    }
}
