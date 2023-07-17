package org.example.repository;

public interface IRelatorioRepository {
    public abstract int gerarQtdTraidores();
    public abstract int gerarQtdRebeldes();
    public abstract double gerarPorcentagemTraidores();
    public abstract double gerarPorcentagemRebeldes();
}
