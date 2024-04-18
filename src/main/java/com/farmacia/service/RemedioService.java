package com.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.farmacia.dto.RemedioDto;
import com.farmacia.entity.Remedio;
import com.farmacia.repository.RemedioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RemedioService {

	private final RemedioRepository repository;
	
	public Remedio cadastrarRemedio(RemedioDto remedio) {
		var cadastrar = new Remedio(remedio);
		return repository.save(cadastrar);
		
		
	}
	
	public List<Remedio>listarTodos(){
		return repository.findAll();
	}
	
	public Remedio buscarPorId(Long id) {
		Optional<Remedio>buscar = repository.findById(id);
		return buscar.orElseThrow();
	}
	
	@Transactional
	public Remedio atualizar(RemedioDto remedio) {	
	  var atualize =repository.getReferenceById(remedio.id());
	  atualize.atualizarRemedio(remedio);
	  return atualize;
	
	}
	public void delete(Long id) {
		repository.deleteById(id);
		
		}
	
	
	
	
}
