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

    public void gerarRelatorio(){
        int qtdRebeldes = gerarQtdRebeldes();
        int qtdTraidores = gerarQtdTraidores();
        int qtdTotal = qtdRebeldes + qtdTraidores;
        relatorio.setPorcentagemTraidores(( ((double) qtdTraidores /qtdTotal) * 100));
        relatorio.setPorcentagemRebeldes(((double) qtdRebeldes /qtdTotal) * 100);

        System.out.println("Quantidade total de pessoas: " + qtdTotal);
        System.out.println("Quantidade total de Rebeldes: " + qtdRebeldes);
        System.out.println("Quantidade total de Traidores: " + qtdTraidores);
        System.out.printf("Porcentagem de Rebeldes: %.2f%% %n", relatorio.getPorcentagemRebeldes());
        System.out.printf("Porcentagem de Traidores: %.2f%% %n", relatorio.getPorcentagemTraidores());
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
