package org.example.view;

import org.example.controller.RebeldeController;
import org.example.model.RebeldeModel;
import org.example.service.RebeldeService;
import java.util.Scanner;

import static org.example.view.MenuView.limparConsole;
import static org.example.view.MenuView.selecionarOpcao;

public class RebeldeView {

    private Scanner sc;
    private final RebeldeController rebeldeController;
    private RebeldeService rebeldeService;
    private RebeldeModel rebelde;

    public RebeldeView() {
        sc = new Scanner(System.in);
        rebeldeService = new RebeldeService();
        rebeldeController = new RebeldeController(rebeldeService);

    }

    public void imprimirMenuRebelde(){
        int opcao;
        do {
            System.out.println("------ Menu Rebelde ------");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1 - Consultar todos os Rebeldes");
            System.out.println("2 - Consultar Rebelde específico");
            System.out.println("3 - Cadastrar Rebelde");
            System.out.println("4 - Atualizar dados de um Rebelde");
            System.out.println("5 - Deletar Rebelde");
            System.out.println("6 - Reportar um rebelde");
            System.out.println("0 - Retornar ao MENU PRINCIPAL");
            opcao = selecionarOpcao();
            limparConsole();

            switch (opcao) {
                case 1:
                    rebeldeController.buscarTodosRebeldes();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 2:
                    imprimirConsultarRebeldeEspecifico();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 3:
                    imprimirCadastrarRebelde();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 4:
                    imprimirAtualizarDadosRebelde();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 5:
                    imprimirDeletarRebelde();
                    System.out.println("Digite ENTER para voltar ao Menu");
                    sc.nextLine();
                    limparConsole();
                    break;
                case 6:
                    imprimirReportarRebelde();
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



    public void imprimirConsultarRebeldeEspecifico(){
        System.out.print("Digite o ID do rebelde ");
        Long id = sc.nextLong();
        sc.nextLine();
        rebeldeController.buscarRebeldePorId(id);
    }

    public void imprimirCadastrarRebelde(){
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
        rebeldeController.cadastrarRebelde(rebelde);
    }

    public void imprimirAtualizarDadosRebelde(){
        System.out.println("Digite o id do Rebelde: ");
        Long idRebelde = sc.nextLong();
        sc.nextLine();
        System.out.println("Você deseja atualizar qual informação? (Nome, idade, gênero)");
        System.out.println("Digite aqui: ");
        String coluna = sc.nextLine();
        System.out.println("Digite o novo valor que você deseja atualizar");
        String valorAtualizado = sc.nextLine();
        rebeldeController.atualizarDadosPessoais(idRebelde, coluna, valorAtualizado);
    }

    public void imprimirDeletarRebelde(){
        System.out.println("Digite o id do rebelde: ");
        Long idRebelde = sc.nextLong();
        rebeldeController.deletarRebelde(idRebelde);
    }

    public void imprimirReportarRebelde(){
        System.out.println("Digite o id do rebelde denunciante: ");
        Long idDenunciante = sc.nextLong();
        System.out.println("Digite o id do rebelde a ser reportado: ");
        Long idReportado = sc.nextLong();
        rebeldeController.reportarRebelde(idDenunciante, idReportado);
        rebeldeController.alterarStatusTraidor(idReportado);
    }

}
