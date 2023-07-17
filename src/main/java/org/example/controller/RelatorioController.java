package org.example.controller;

import org.example.repository.IRelatorioRepository;
import org.example.service.RelatorioService;

public class RelatorioController implements IRelatorioRepository {
    private RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    public double gerarPorcentagemRebeldes(){
        return relatorioService.gerarPorcentagemRebeldes();
    }

    public double gerarPorcentagemTraidores(){
        return relatorioService.gerarPorcentagemTraidores();
    }

    public int gerarQtdRebeldes(){
        return relatorioService.gerarQtdRebeldes();
    }

    public int gerarQtdTraidores(){
        return relatorioService.gerarQtdTraidores();
    }
}
