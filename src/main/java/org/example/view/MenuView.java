package org.example.view;

import org.example.model.RebeldeModel;
import org.example.service.RelatorioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private InventarioView inventarioView;
    private RebeldeView rebeldeView;
    private RelatorioView relatorioView;
    private ItemView itemView;
    private Scanner sc;

    public MenuView(){
        inventarioView = new InventarioView();
        rebeldeView = new RebeldeView();
        relatorioView = new RelatorioView();
        itemView = new ItemView();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            imprimirMenu();
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao) {
                case 1:
                    rebeldeView.imprimirMenuRebelde();
                    break;
                case 2:
                    itemView.imprimirMenuItem();
                    break;
                case 3:
                    inventarioView.imprimirMenuInventario();
                    break;
                case 4:
                    relatorioView.imprimirMenuRelatorio();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 10);
    }

    public void imprimirMenu() {
        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("1 - Acessar Menu REBELDE");
        System.out.println("2 - Acessar Menu LOJA");
        System.out.println("3 - Acessar Menu INVENTARIO");
        System.out.println("4 - Acessar Menu RELATÓRIO");


        System.out.println("Digite aqui a opção: ");
    }

    public static int selecionarOpcao() {
        Scanner sc = new Scanner(System.in);
        try {
            int opcao = sc.nextInt();
            sc.nextLine();
            limparConsole();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
            return 0;
        }
    }

    public static void limparConsole(){
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
