package org.example.repository;

public interface IIventarioRepository {
    public abstract void visualizarInventario(Long idRebelde);
    public abstract void adicionarItemInventario(Long idRebelde, Long idItem);
}
