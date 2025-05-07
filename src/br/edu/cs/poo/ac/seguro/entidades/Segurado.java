package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal; 
import java.io.Serializable;

import java.time.LocalDate;
import java.time.Period;

public class Segurado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
    private String nome;
    private Endereco endereco;
    private LocalDate dataCriacao;
    private BigDecimal bonus;

    public Segurado(String nome, Endereco endereco, LocalDate dataCriacao, BigDecimal bonus){
        this.nome = nome;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
        this.bonus = bonus;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    protected void setDataCriacao(LocalDate dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    protected LocalDate getDataCriacao(){
        return dataCriacao;
    }

    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataCriacao, dataAtual).getYears();
    }

    public BigDecimal getBonus() {
        return bonus;
    }
    
    public void creditarBonus(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            bonus = bonus.add(valor);
        }else{
            System.out.println("O valor deve ser maioe que 0");
        }
    }

    public void debitarBonus(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && bonus.compareTo(valor) >= 0) {
            bonus = bonus.subtract(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

}