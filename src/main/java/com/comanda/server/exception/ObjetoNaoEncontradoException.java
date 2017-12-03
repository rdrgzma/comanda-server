package com.comanda.server.exception;

public class ObjetoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public ObjetoNaoEncontradoException(String msg, Throwable causa) {
		super(msg,causa);
	}
}
