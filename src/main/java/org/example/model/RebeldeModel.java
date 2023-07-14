package org.example.model;

public class RebeldeModel {
    private Long id;
    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private boolean traidor;
    private boolean ativo;

    public RebeldeModel(){

    }
    public RebeldeModel(Long id, String nome, int idade, String genero, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
        this.traidor = false;
        this.ativo = true;
    }

    public RebeldeModel(Long id, String nome, int idade, String genero, String localizacao, boolean traidor, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
        this.traidor = traidor;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isTraidor() {
        return traidor;
    }

    public void setTraidor(boolean traidor) {
        this.traidor = traidor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
