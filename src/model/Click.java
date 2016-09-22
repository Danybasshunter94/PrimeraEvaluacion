package model;

import java.util.Date;

public class Click {
	private int contador;
	private Cont cont;
	private Date fecha;
	
	public Click(int contador) {
		super();
		this.contador = contador;
		fecha = new Date();
	}
	
	public Click(Cont cont){
		this.cont = cont;
		fecha = new Date();
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

	
}
