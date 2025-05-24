package com.example.jogadoresBackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Insira o nome do Jogador")
    private String nome;
    @NotBlank(message = "Insira o Sexo do Jogador")
    private String sexo;
    @NotNull
    private int idade;
    @NotNull
    private Double altura;
    @NotNull
    private Double peso;
    @NotBlank(message = "Insira a posição do Jogador")
    private String posicao;
    @NotNull
    private int numeroDaCamisa;

    public Jogador() {
    }

    public Jogador(long id, String nome, String sexo, int idade, Double altura, Double peso, String posicao, int numeroDaCamisa) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.posicao = posicao;
        this.numeroDaCamisa = numeroDaCamisa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNumeroDaCamisa() {
        return numeroDaCamisa;
    }

    public void setNumeroDaCamisa(int numeroDaCamisa) {
        this.numeroDaCamisa = numeroDaCamisa;
    }
}
