package br.com.senac.service;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7638223162063520607L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
