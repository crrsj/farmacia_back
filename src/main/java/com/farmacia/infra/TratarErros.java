package com.farmacia.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class TratarErros extends ResponseEntityExceptionHandler {
    
	@ExceptionHandler(NoSuchElementException.class)
	private ResponseEntity<MensagemDeErros> idNaoEncontrado(){
		var response = new MensagemDeErros(HttpStatus.NOT_FOUND,"ID não encontrado!");
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
}