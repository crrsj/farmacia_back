package com.farmacia.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.farmacia.dto.RemedioDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="remedios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remedio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String imagem;
	private String validade = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
	private int quantidade;
	
    
	
	public Remedio(RemedioDto remedio) {
	
	 this.nome = remedio.nome();
	 this.imagem = remedio.imagem();
	 this.validade = remedio.validade();
	 this.quantidade = remedio.quantidade();
	 
	}


	public void atualizarRemedio(RemedioDto remedio) {
		if(remedio.nome()!=null) {
			this.nome = remedio.nome();
		}
		
		if(remedio.validade()!=null) {
			this.validade = remedio.validade();
		}
		this.quantidade = remedio.quantidade();			
		}
	    

	}
	

