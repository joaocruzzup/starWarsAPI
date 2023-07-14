package org.example.service;

import org.example.model.ItemModel;
import org.example.model.RebeldeModel;
import org.example.repository.IItemRepository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.connection.Conexao.getConnection;

public class ItemService implements IItemRepository {

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

    @Override
    public void adicionarItem(ItemModel item) {
        String sql = String.format("INSERT INTO base_compras (nome_item, valor)" +
                        " VALUES (%s, %f')",
                item.getNome(), item.getValor());
        try {
            statement.executeUpdate(sql);
            System.out.println("Item " + item.getNome() + " adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarValor(Long id, BigDecimal valor) {
        String sql = String.format("UPDATE base_compras SET valor = '%s' where id_rebelde = '%d'", valor, id);
        try {
            statement.executeUpdate(sql);
            System.out.println("Item de ID " + id + " atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ItemModel> buscarTodosItens() {
        String sql = "SELECT * FROM base_compras";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idItem = resultSet.getLong("id_rebelde");
                String nomeItem = resultSet.getString("id_item");
                BigDecimal valorItem = resultSet.getBigDecimal("valor");
                ItemModel item = new ItemModel(idItem, nomeItem, valorItem);
                itens.add(item);
            }
            return itens;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ItemModel buscarItemPorId(Long id) {
        String sql = String.format("SELECT * FROM base_compras WHERE id = %s", id);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idItem = resultSet.getLong("id_rebelde");
                String nomeItem = resultSet.getString("id_item");
                BigDecimal valorItem = resultSet.getBigDecimal("valor");
                item = new ItemModel(idItem, nomeItem, valorItem);
            }
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
