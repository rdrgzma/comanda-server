package com.comanda.server.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado( ObjetoNaoEncontradoException e, HttpServletRequest request){

		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}

}
