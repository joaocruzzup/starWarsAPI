package org.example.service;

import org.example.model.RelatorioModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.connection.Conexao.getConnection;

public class RelatorioService {

    private Statement statement;
    private RelatorioModel relatorio;

    public RelatorioService() {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        relatorio = new RelatorioModel();
    }

    public double gerarPorcentagemRebeldes(){
        relatorio.setPorcentagemRebeldes(((double) gerarQtdRebeldes() / (gerarQtdRebeldes() + gerarQtdTraidores())) * 100);
        return relatorio.getPorcentagemRebeldes();
    }

    public double gerarPorcentagemTraidores(){
        relatorio.setPorcentagemRebeldes(((double) gerarQtdTraidores() / (gerarQtdRebeldes() + gerarQtdTraidores())) * 100);
        return relatorio.getPorcentagemRebeldes();
    }

    public int gerarQtdRebeldes(){
        String sql = "SELECT count(traidor) AS qtd_rebeldes FROM rebeldes WHERE traidor IS FALSE";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            int qtdRebeldes = 0;
            while (resultSet.next()){
                qtdRebeldes = resultSet.getInt("qtd_rebeldes");

            }
            return qtdRebeldes;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public int gerarQtdTraidores(){
        String sql = "SELECT count(traidor) AS qtd_traidores FROM rebeldes WHERE traidor IS TRUE";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            int qtdTraidores = 0;
            while (resultSet.next()){
                qtdTraidores = resultSet.getInt("qtd_traidores");

            }
            return qtdTraidores;
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
}
