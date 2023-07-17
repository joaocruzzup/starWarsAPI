package org.example.view;

import org.example.controller.InventarioController;
import org.example.controller.ItemController;
import org.example.model.ItemModel;
import org.example.model.RebeldeModel;
import org.example.service.InventarioService;
import org.example.service.ItemService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static org.example.view.MenuView.limparConsole;
import static org.example.view.MenuView.selecionarOpcao;

public class ItemView {
    private ItemController itemController;
    private Scanner sc;

    public ItemView() {
        ItemService itemService = new ItemService();
        sc = new Scanner(System.in);
        itemController = new ItemController(itemService);
    }

    public void imprimirMenuItem(){
        int opcao;
        do {
            System.out.println("------ Menu Loja ------");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1 - Consultar todos os Itens disponíveis");
            System.out.println("2 - Consultar Item específico");
            System.out.println("3 - Cadastrar Item");
            System.out.println("4 - Atualizar Item");

            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao) {
                case 1:
                    itemController.buscarTodosItens();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 2:
                    imprimirConsultarItemEspecifico();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 3:
                    imprimirCadastrarItem();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 4:
                    imprimirAtualizarValor();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;

                default:
                    System.out.println("Digite uma opção válida");
                    limparConsole();
                    break;
            }
        } while (opcao != 0);
    }

    public void imprimirConsultarItemEspecifico(){
        System.out.print("Digite o ID do rebelde ");
        Long id = sc.nextLong();
        sc.nextLine();
        itemController.buscarItemPorId(id);
    }

    public void imprimirCadastrarItem(){
        System.out.print("Digite o nome do Item: ");
        String nome = sc.nextLine();
        System.out.print("Digite o valor do Item: ");
        BigDecimal valor = sc.nextBigDecimal();
        sc.nextLine();
        ItemModel item = new ItemModel(nome, valor);
        itemController.adicionarItem(item);
    }

    public void imprimirAtualizarValor(){
        System.out.println("Digite o id do Rebelde: ");
        Long idItem = sc.nextLong();
        sc.nextLine();
        System.out.println("Você deseja atualizar qual informação? (nome, valor)");
        System.out.println("Digite aqui: ");
        String coluna = sc.nextLine();
        System.out.println("Digite o novo valor que você deseja atualizar");
        String valorAtualizado = sc.nextLine();
        itemController.atualizarValor(idItem, coluna, valorAtualizado);
    }

}
