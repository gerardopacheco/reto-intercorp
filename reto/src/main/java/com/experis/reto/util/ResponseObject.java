package com.experis.reto.util;

public class ResponseObject {

	private Estado estado;
	private Error error;
	private Object resultado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public void setError(Integer codigo, String mensaje, String mensajeInterno) {
		this.error = new Error(codigo, mensaje, mensajeInterno);
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

}
