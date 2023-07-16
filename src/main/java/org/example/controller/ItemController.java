package org.example.controller;

import org.example.model.ItemModel;
import org.example.repository.IItemRepository;
import org.example.service.ItemService;

import java.math.BigDecimal;
import java.util.List;

public class ItemController implements IItemRepository {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @Override
    public void adicionarItem(ItemModel item) {
        itemService.adicionarItem(item);
    }

    @Override
    public void atualizarValor(Long id, BigDecimal valor) {
        itemService.atualizarValor(id, valor);
    }

    @Override
    public List<ItemModel> buscarTodosItens() {
        return itemService.buscarTodosItens();
    }

    @Override
    public ItemModel buscarItemPorId(Long id) {
        return itemService.buscarItemPorId(id);
    }
}
