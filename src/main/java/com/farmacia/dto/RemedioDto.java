package com.farmacia.dto;

import com.farmacia.entity.Remedio;

import jakarta.validation.constraints.NotBlank;

public record RemedioDto(  
		Long id,
		@NotBlank(message = "Não pose ser vazio")
		String nome,		
		String imagem,
		@NotBlank(message = "Não pose ser vazio")
		String validade,		
		int quantidade
		               ) {

	public RemedioDto(Remedio cadastre) {
		this(
				cadastre.getId(),
				cadastre.getNome(),
				cadastre.getImagem(),
				cadastre.getValidade(),
				cadastre.getQuantidade());
		        
	}

}
