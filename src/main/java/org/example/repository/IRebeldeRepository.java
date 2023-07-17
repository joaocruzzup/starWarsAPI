package org.example.repository;

import org.example.model.RebeldeModel;

import java.util.List;

public interface IRebeldeRepository {
    public abstract List<RebeldeModel> buscarTodosRebeldes();
    public abstract RebeldeModel buscarRebeldePorId(Long id);
    public abstract void cadastrarRebelde(RebeldeModel rebelde);
    public abstract void deletarRebelde(Long id);
    public abstract void atualizarDadosPessoais(Long id, String coluna, String valorAtualizado);
    public abstract void atualizarLocalizacao(Long id, String localizacao);
    public abstract void reportarRebelde(Long id, Long idReportado);
    public abstract boolean alterarStatusTraidor(Long idRebelde);
}
