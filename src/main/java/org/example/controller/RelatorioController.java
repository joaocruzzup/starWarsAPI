package org.example.controller;

import org.example.service.RelatorioService;

public class RelatorioController {
    private RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    public void gerarRelatorio(){
        relatorioService.gerarRelatorio();
    }
}
