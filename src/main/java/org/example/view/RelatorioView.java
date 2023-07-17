package org.example.view;

import org.example.controller.RelatorioController;
import org.example.service.RelatorioService;

import java.util.Scanner;

import static org.example.view.MenuView.limparConsole;
import static org.example.view.MenuView.selecionarOpcao;

public class RelatorioView {

    private RelatorioService relatorioService = new RelatorioService();

    private RelatorioController relatorioController;
    private Scanner sc;

    public RelatorioView() {
        relatorioController = new RelatorioController(relatorioService);
        sc = new Scanner(System.in);
    }

    public void imprimirMenuRelatorio() {
        int opcao;
        do {
            System.out.println("------ Menu Relatório ------");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1 - Visualizar relatório");
            System.out.println("0 - retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao) {
                case 1:
                    imprimirRelatorio();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    limparConsole();
                    break;
            }

        }while (opcao != 0) ;
    }

    public void imprimirRelatorio() {
        int qtdRebeldes = relatorioController.gerarQtdRebeldes();
        int qtdTraidores = relatorioController.gerarQtdTraidores();
        double porcentagemRebeldes = relatorioController.gerarPorcentagemRebeldes();
        double porcentagemTraidores = relatorioController.gerarPorcentagemTraidores();

        System.out.println(" -----------------------------------------");
        System.out.println(" --- Relatório de Rebeldes e Traidores ---");
        System.out.println(" -----------------------------------------");
        System.out.println(" |            | Quantidade | Porcentagem |");
        System.out.printf(" |  Rebeldes  |     %d      |    %.2f%%   |   %n", qtdRebeldes, porcentagemRebeldes);
        System.out.printf(" |  Traidores |     %d      |    %.2f%%   |   %n", qtdTraidores, porcentagemTraidores);
        System.out.printf(" |            |            |             |   %n");
        System.out.printf(" |   TOTAL:   |     %d      |   100,00%%   |   %n", qtdTraidores + qtdRebeldes);
        System.out.println(" -----------------------------------------");
    }
}
