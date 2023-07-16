package org.example.view;

import org.example.model.RebeldeModel;
import org.example.service.InventarioService;
import org.example.service.RebeldeService;
import org.example.service.RelatorioService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RebeldeView {

    private Scanner sc;
    private RebeldeService rebeldeService;
    private RebeldeModel rebelde;

    public RebeldeView() {
        sc = new Scanner(System.in);
        rebeldeService = new RebeldeService();
    }

    public void iniciar() {
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
                    System.out.println("Digite o id do Rebelde: ");
                    Long idRebelde = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Você deseja atualizar qual informação? (Nome, idade, gênero)");
                    System.out.println("Digite aqui: ");
                    String coluna = sc.nextLine();
                    System.out.println("Digite o novo valor que você deseja atualizar");
                    String valorAtualizado = sc.nextLine();
                    rebeldeService.atualizarColuna(idRebelde, coluna, valorAtualizado);
                    break;
                case 5:
                    System.out.println("Digite o id do rebelde: ");
                    idRebelde = sc.nextLong();
                    rebeldeService.deletarRebelde(idRebelde);
                    break;
                case 6:
                    System.out.println("Digite o id do rebelde denunciante: ");
                    Long idDenunciante = sc.nextLong();
                    System.out.println("Digite o id do rebelde a ser reportado: ");
                    Long idReportado = sc.nextLong();
                    rebeldeService.reportarRebelde(idDenunciante, idReportado);
                    rebeldeService.alterarStatusTraidor(idReportado);
                    break;
                case 7:
                    System.out.println("Digite o id do rebelde: ");
                    idRebelde = sc.nextLong();
                    rebeldeService.visualizarInventario(idRebelde);
                    break;
                case 8:
                    System.out.println("Digite o id do rebelde: ");
                    idRebelde = sc.nextLong();
                    System.out.println("Digite o id do item: ");
                    Long idItem = sc.nextLong();
                    rebeldeService.comprarItem(idRebelde, idItem);
                    break;
                case 9:
                    RelatorioService relatorioService = new RelatorioService();
                    relatorioService.gerarRelatorio();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 10);
    }


    public void imprimirMenuRebelde() {
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("1 - Consultar todos os Rebeldes");
        System.out.println("2 - Consultar Rebelde específico");
        System.out.println("3 - Cadastrar Rebelde");
        System.out.println("4 - Atualizar dados de um Rebelde");
        System.out.println("5 - Deletar Rebelde");
        System.out.println("6 - Reportar um rebelde");
        System.out.println("7 - Visualizar inventário de um Rebelde");
        System.out.println("8 - Comprar item para um Rebelde");
        System.out.println("9 - Visualizar relatório");
        System.out.println("10 - Sair");
        System.out.println("Digite aqui a opção: ");
    }

    public int selecionarOpcao() {
        try {
            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
            return 0;
        }
    }
}
