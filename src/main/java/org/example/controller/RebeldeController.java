package org.example.controller;

import org.example.model.RebeldeModel;
import org.example.repository.IRebeldeRepository;
import org.example.service.RebeldeService;

import java.util.List;

public class RebeldeController implements IRebeldeRepository {
    private RebeldeService rebeldeService;

    public RebeldeController(RebeldeService rebeldeService) {
        this.rebeldeService = rebeldeService;
    }

    @Override
    public List<RebeldeModel> buscarTodosRebeldes() {
        return rebeldeService.buscarTodosRebeldes();
    }

    @Override
    public RebeldeModel buscarRebeldePorId(Long id) {
        return rebeldeService.buscarRebeldePorId(id);
    }

    @Override
    public void cadastrarRebelde(RebeldeModel rebelde){
        rebeldeService.cadastrarRebelde(rebelde);
    }

    @Override
    public void deletarRebelde(Long id) {
        rebeldeService.deletarRebelde(id);
    }

    @Override
    public void atualizarDadosPessoais(Long id, String coluna, String valorAtualizado) {
        rebeldeService.atualizarDadosPessoais(id, coluna, valorAtualizado);
    }

    @Override
    public void atualizarLocalizacao(Long id, String localizacao) {
        rebeldeService.atualizarLocalizacao(id, localizacao);
    }

    @Override
    public void reportarRebelde(Long id, Long idReportado) {
        rebeldeService.reportarRebelde(id, idReportado);
    }

    public void alterarStatusTraidor(Long id){
        rebeldeService.alterarStatusTraidor(id);
    }

}
