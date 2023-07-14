package org.example.repository;

import org.example.model.RebeldeModel;

import java.util.List;

public interface IRebeldeRepository {
    public abstract List<RebeldeModel> buscarTodosRebeldes();
    public abstract RebeldeModel buscarRebeldePorId(Long id);
    public abstract void adicionarRebelde(RebeldeModel rebelde);
    public abstract void atualizarLocalizacao(Long id, String localizacao);
    public abstract void reportarRebelde(Long id);
    public abstract void comprarItem(Long idRebelde, Long idItem);
}
