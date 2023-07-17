package org.example.service;

import org.example.model.InventarioModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.example.connection.Conexao.getConnection;

public class InventarioService {

    private InventarioModel inventario;
    private Statement statement;
    private RebeldeService rebeldeService;


    public InventarioService(){
        inventario = new InventarioModel();
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rebeldeService = new RebeldeService();
    }

    public void visualizarInventario(Long idRebelde){
        String sql = String.format("SELECT rebeldes.id_rebelde, base_compras.nome_item  \n" +
                "FROM rebeldes \n" +
                "INNER JOIN inventario_rebeldes\n" +
                "ON rebeldes.id_rebelde = inventario_rebeldes.rebelde_id \n" +
                "INNER JOIN base_compras \n" +
                "ON inventario_rebeldes.item_id = base_compras.id_item \n" +
                "WHERE rebeldes.id_rebelde = '%d'", idRebelde);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            int i = 1;
            System.out.println(" --------------");
            while (resultSet.next()){
                String item = resultSet.getString("nome_item");
                System.out.printf("| Item %d: %s |%n", i, item);
                System.out.println(" --------------");
                i++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void adicionarItemInventario(Long idRebelde, Long idItem) {
        if (!rebeldeService.alterarStatusTraidor(idRebelde)){
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
