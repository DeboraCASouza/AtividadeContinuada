	 package br.edu.cs.poo.ac.seguro.entidades;

import lombok.AllArgsConstructor;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class Apolice implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private String numero;
	
    private Veiculo veiculo;
    private BigDecimal valorFranquia;
    private BigDecimal valorPremio;
    private BigDecimal valorMaximoSegurado;
	private LocalDate dataInicioVigencia;
	
}
