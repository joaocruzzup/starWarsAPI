package org.example.service;

import org.example.model.ItemModel;
import org.example.model.RebeldeModel;
import org.example.repository.IItemRepository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.Conexao.getConnection;

public class ItemService{

    private Statement statement;
    private ItemModel item;
    private List<ItemModel> itens;


    public ItemService() {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemModel item) {
        String valor = String.valueOf(item.getValor()).replace(",", ".");
        String sql = String.format("INSERT INTO base_compras (nome, valor)" +
                        " VALUES ('%s', '%s')",
                item.getNome(), valor);
        try {
            statement.executeUpdate(sql);
            System.out.println("Item " + item.getNome() + " adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarValor(Long id, String coluna, String valorAtualizado) {
        if (coluna.equalsIgnoreCase("nome") || coluna.equalsIgnoreCase("valor")) {
            String sql;
            if (coluna.equalsIgnoreCase("valor")){
                valorAtualizado = String.valueOf(new BigDecimal(valorAtualizado.replace(",", ".")));
                sql = String.format("UPDATE base_compras SET valor = '%s' where id_item = '%d'", valorAtualizado, id);
            } else {
                sql = String.format("UPDATE rebeldes SET nome = '%s' where id_rebelde = '%d'", valorAtualizado, id);
            }
            try {
                statement.executeUpdate(sql);
                System.out.println("Rebelde de ID " + id + " atualizado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Apenas é possível atualizar nome ou valor");
        }
    }

    public List<ItemModel> buscarTodosItens() {
        String sql = "SELECT * FROM base_compras ORDER BY id_item";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idItem = resultSet.getLong("id_item");
                String nomeItem = resultSet.getString("nome");
                BigDecimal valorItem = resultSet.getBigDecimal("valor");
                ItemModel item = new ItemModel(idItem, nomeItem, valorItem);
                System.out.println("ID: " + idItem + " | Nome: " + nomeItem + " | valor: " + valorItem +" |");

                itens.add(item);
            }
            return itens;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ItemModel buscarItemPorId(Long id) {
        String sql = String.format("SELECT * FROM base_compras WHERE id_item = '%s'", id);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idItem = resultSet.getLong("id_item");
                String nomeItem = resultSet.getString("nome");
                BigDecimal valorItem = resultSet.getBigDecimal("valor");
                System.out.println("ID: " + idItem + " | Nome: " + nomeItem + " | valor: " + valorItem +" |");
                item = new ItemModel(idItem, nomeItem, valorItem);
            }
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
