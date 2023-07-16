package org.example.view;
import org.example.model.RebeldeModel;
import org.example.service.RebeldeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RebeldeView {

    private Scanner sc;
    private RebeldeService rebeldeService;
    private RebeldeModel rebelde;

    public RebeldeView(){
        sc = new Scanner(System.in);
        rebeldeService = new RebeldeService();
    }

    public void iniciar(){
        int opcao;
        do {
            imprimirMenuRebelde();
            opcao = selecionarOpcao();

            switch (opcao) {
                case 1:
                    rebeldeService.buscarTodosRebeldes();
                    break;
                case 2:
                    System.out.print("Digite o ID do rebelde ");
                    Long id = sc.nextLong();
                    rebeldeService.buscarRebeldePorId(id);
                    break;
                case 3:
                    System.out.print("Digite o nome do Rebelde: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a idade do Rebelde: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o gênero do Rebelde: ");
                    String genero = sc.next();
                    sc.nextLine();
                    System.out.print("Digite a localização do Rebelde: ");
                    String localizacao = sc.nextLine();
                    System.out.println("Digite o ");
                    rebelde = new RebeldeModel(nome, idade, genero, localizacao);
                    rebeldeService.cadastrarRebelde(rebelde);
                    break;
                case 4:

                case 5:

                case 6:
                    System.out.println("Digite o id do rebelde: ");
                    Long idRebelde = sc.nextLong();
                    System.out.println("Digite o id do item: ");
                    Long idItem = sc.nextLong();
                    rebeldeService.comprarItem(idRebelde, idItem);
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }


    public void imprimirMenuRebelde(){
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("1 - Consultar todos os Rebeldes");
        System.out.println("2 - Consultar Rebelde específico");
        System.out.println("3 - Cadastrar Rebelde");
        System.out.println("4 - Atualizar dados de um Rebelde");
        System.out.println("5 - Deletar Rebelde");
        System.out.println("6 - Comprar item para um Rebelde");
        System.out.println("7 - Visualizar inventário de um Rebelde");
        System.out.println("8 - Reportar um rebelde");
        System.out.println("9 - Visualizar relatório");
        System.out.println("10 - Sair");
        System.out.println("Digite aqui a opção: ");
    }

    public int selecionarOpcao(){
        try {
            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            sc.nextLine();
            return 0;
        }
    }
}
