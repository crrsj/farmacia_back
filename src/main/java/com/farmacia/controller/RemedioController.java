package com.farmacia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.farmacia.dto.RemedioDto;
import com.farmacia.service.RemedioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("remedio")
@RequiredArgsConstructor
@CrossOrigin(origins =  "*")
public class RemedioController {
	
	private final RemedioService service;

	@PostMapping
	public ResponseEntity<RemedioDto>cadastrarRemedio(@RequestBody @Valid RemedioDto remedio){
		var cadastre = service.cadastrarRemedio(remedio);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("remedio/{id}")
		.buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new RemedioDto(cadastre));
	}
	
	@GetMapping
	public ResponseEntity<List<RemedioDto>>buscarTodos(){
		var busca = service.listarTodos().stream().map(RemedioDto::new).toList();
		return ResponseEntity.ok(busca);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?>buscarPorId(@PathVariable Long id){
		var buscar = service.buscarPorId(id);
		return ResponseEntity.ok().body(buscar);
	}
	
	@PutMapping
	public ResponseEntity<RemedioDto> atualizar(@RequestBody @Valid RemedioDto remedio){
		var atualiza = service.atualizar(remedio);
		return ResponseEntity.ok().body(new RemedioDto(atualiza));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		 service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
           Map<String, String> errors = new HashMap<>();
           ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
       // return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
           return ResponseEntity.badRequest().body(errors);
	 }
}
