package org.example.service;

import org.example.model.RebeldeModel;
import org.example.repository.IRebeldeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.Conexao.getConnection;

public class RebeldeService implements IRebeldeRepository {

    private Statement statement;
    private RebeldeModel rebelde;
    private List<RebeldeModel> rebeldes;

    public RebeldeService() {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rebeldes = new ArrayList<>();
    }

    @Override
    public List<RebeldeModel> buscarTodosRebeldes() {
        String sql = "SELECT * FROM rebeldes";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                Long idRebelde = resultSet.getLong("id_rebelde");
                String nomeRebelde = resultSet.getString("nome_rebelde");
                int idadeRebelde = resultSet.getInt("idade");
                String generoRebelde = resultSet.getString("genero");
                String localizacaoRebelde = resultSet.getString("localizacao");
                boolean traidor = resultSet.getBoolean("traidor");
                boolean ativo = resultSet.getBoolean("ativo");
                RebeldeModel rebelde = new RebeldeModel(idRebelde, nomeRebelde, idadeRebelde, generoRebelde, localizacaoRebelde, traidor, ativo);
                rebeldes.add(rebelde);
            }
            return rebeldes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RebeldeModel buscarRebeldePorId(Long id) {
        String sql = String.format("SELECT * FROM rebeldes WHERE id = %s", id);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idRebelde = resultSet.getLong("id_rebelde");
                String nomeRebelde = resultSet.getString("nome_rebelde");
                int idadeRebelde = resultSet.getInt("idade");
                String generoRebelde = resultSet.getString("genero");
                String localizacaoRebelde = resultSet.getString("localizacao");
                boolean traidor = resultSet.getBoolean("traidor");
                boolean ativo = resultSet.getBoolean("ativo");
                rebelde = new RebeldeModel(idRebelde, nomeRebelde, idadeRebelde, generoRebelde, localizacaoRebelde, traidor, ativo);
            }
            return rebelde;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void cadastrarRebelde(RebeldeModel rebelde) {
        String sql = String.format("INSERT INTO rebeldes (nome, idade, genero, localizacao)" +
                        " VALUES ('%s, %d, %s, %s')",
                rebelde.getNome(), rebelde.getIdade(), rebelde.getGenero(), rebelde.getLocalizacao());
        try {
            statement.executeUpdate(sql);
            System.out.println("Rebelde " + rebelde.getNome() + " adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarLocalizacao(Long id, String localizacao) {
        String sql = String.format("UPDATE rebeldes SET localizacao = '%s' where id_rebelde = '%d'", localizacao, id);
        try {
            statement.executeUpdate(sql);
            System.out.println("Rebelde de ID " + id + " atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reportarRebelde(Long idDenunciante, Long idReportado) {
        String sql = String.format("INSERT INTO reports (denunciante_id, reportado_id) VALUES ('%d', '%d'", idDenunciante, idReportado);
        try {
            statement.executeUpdate(sql);
            System.out.println("Rebelde " + idReportado + " reportado com sucesso! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarTraidor(Long idRebelde){
        String sql = String.format("SELECT reportado_id, COUNT(*) AS qtd_reports FROM reports WHERE reportado_id = '%d' GROUP BY reportado_id", idRebelde);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            int qtdReports = 0;
            while (resultSet.next()){
                qtdReports = resultSet.getInt("qtd_reports");
            }
            return qtdReports >= 3;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterarStatusTraidor(Long idRebelde){
        if (verificarTraidor(idRebelde)){
            String sql = String.format("UPDATE rebeldes SET traidor = 'true', ativo = 'false' where id_rebelde = '%d'", idRebelde);
            try {
                statement.executeUpdate(sql);
                System.out.println("Rebelde de ID " + idRebelde + " atualizado como traidor!");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void comprarItem(Long idRebelde, Long idItem) {
        if (!alterarStatusTraidor(idRebelde)){
            String sql = String.format("INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES ('%d', '%d')", idRebelde, idItem);
            try {
                statement.executeUpdate(sql);
                System.out.println("item " + idItem + " comprado pelo rebelde: " + idRebelde + " com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Não é possível realizar compras para um traidor!");
        }

    }

}