package org.example.view;

import org.example.controller.RelatorioController;
import org.example.service.RelatorioService;

public class RelatorioView {

    private RelatorioService relatorioService = new RelatorioService();

    private RelatorioController relatorioController;

    public RelatorioView(){
        relatorioController = new RelatorioController(relatorioService);
    }

    public void imprimirRelatorio(){
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
