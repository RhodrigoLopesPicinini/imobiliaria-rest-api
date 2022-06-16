package com.imed.imobiliaria.exception;

@SuppressWarnings("serial")
public class ImobiliariaNotFoundException extends RuntimeException {

	public ImobiliariaNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}