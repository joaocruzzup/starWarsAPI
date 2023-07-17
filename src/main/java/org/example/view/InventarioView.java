package org.example.view;

import org.example.controller.InventarioController;
import org.example.service.InventarioService;

import java.util.Scanner;

import static org.example.view.MenuView.limparConsole;
import static org.example.view.MenuView.selecionarOpcao;

public class InventarioView {
    private InventarioController inventarioController;
    private Scanner sc;

    public InventarioView() {
        InventarioService inventarioService = new InventarioService();
        sc = new Scanner(System.in);
        inventarioController = new InventarioController(inventarioService);
    }

    public void imprimirMenuInventario() {
        int opcao;
        do {
            System.out.println("------ Menu Inventário ------");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1 - Visualizar inventário de um Rebelde");
            System.out.println("2 - Comprar item para um Rebelde");
            System.out.println("0 - retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao) {
                case 1:
                    imprimirVisualizarInventario();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 2:
                    imprimirComprarItem();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    limparConsole();
                    break;
            }

        } while (opcao != 0);
    }

    public void imprimirVisualizarInventario() {
        System.out.println("Digite o id do Rebelde: ");
        Long idRebelde = sc.nextLong();
        sc.nextLine();
        System.out.println("--- Inventário ---");
        inventarioController.visualizarInventario(idRebelde);
    }

    public void imprimirComprarItem() {
        System.out.println("Digite o id do Rebelde: ");
        Long idRebelde = sc.nextLong();
        System.out.println("Digite o id do Item: ");
        Long idItem = sc.nextLong();
        inventarioController.adicionarItemInventario(idRebelde, idItem);
    }
}
