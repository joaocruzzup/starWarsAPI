package org.example.repository;

import org.example.model.ItemModel;

import java.math.BigDecimal;
import java.util.List;

public interface IItemRepository {
    public abstract void adicionarItem(ItemModel item);
    public abstract void atualizarValor(Long id, BigDecimal valor);
    public abstract List<ItemModel> buscarTodosItens();
    public abstract ItemModel buscarItemPorId(Long id);
}
