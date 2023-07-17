package org.example.view;

import org.example.model.RebeldeModel;
import org.example.service.RelatorioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private InventarioView inventarioView;
    private RebeldeView rebeldeView;
    private RelatorioView relatorioView;
    private Scanner sc;

    public MenuView(){
        inventarioView = new InventarioView();
        rebeldeView = new RebeldeView();
        relatorioView = new RelatorioView();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            imprimirMenu();
            opcao = selecionarOpcao();

            switch (opcao) {
                case 1:
                    rebeldeView.imprimirConsultarTodosRebeldes();
                    break;
                case 2:
                    rebeldeView.imprimirConsultarRebeldeEspecifico();
                    break;
                case 3:
                    rebeldeView.imprimirCadastrarRebelde();
                    break;
                case 4:
                    rebeldeView.imprimirAtualizarDadosRebelde();
                    break;
                case 5:
                    rebeldeView.imprimirDeletarRebelde();
                    break;
                case 6:
                    rebeldeView.imprimirReportarRebelde();
                    break;
                case 7:
                    inventarioView.imprimirVisualizarInventario();
                    break;
                case 8:
                    inventarioView.imprimirComprarItem();
                    break;
                case 9:
                    relatorioView.imprimirRelatorio();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 10);
    }

    public void imprimirMenu() {
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("1 - Consultar todos os Rebeldes");
        System.out.println("2 - Consultar Rebelde específico");
        System.out.println("3 - Cadastrar Rebelde");
        System.out.println("4 - Atualizar dados de um Rebelde");
        System.out.println("5 - Deletar Rebelde");
        System.out.println("6 - Reportar um rebelde");
        System.out.println("7 - Visualizar inventário de um Rebelde");
        System.out.println("8 - Comprar item para um Rebelde");
        System.out.println("9 - Visualizar relatório");
        System.out.println("10 - Sair");
        System.out.println("Digite aqui a opção: ");
    }

    public int selecionarOpcao() {
        try {
            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
            return 0;
        }
    }
}
