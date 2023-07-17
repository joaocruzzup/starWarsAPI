package org.example.view;

import org.example.controller.RebeldeController;
import org.example.model.RebeldeModel;
import org.example.service.RebeldeService;
import java.util.Scanner;

public class RebeldeView {

    private Scanner sc;
    private final RebeldeController rebeldeController;
    private RebeldeModel rebelde;

    public RebeldeView() {
        sc = new Scanner(System.in);
        RebeldeService rebeldeService = new RebeldeService();
        rebeldeController = new RebeldeController(rebeldeService);
    }
    public void imprimirConsultarTodosRebeldes(){
        rebeldeController.buscarTodosRebeldes();
    }

    public void imprimirConsultarRebeldeEspecifico(){
        System.out.print("Digite o ID do rebelde ");
        Long id = sc.nextLong();
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
