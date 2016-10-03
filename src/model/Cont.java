package model;

public class Cont {

	private int contador;

	public Cont() {
		super();
		contador = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Cont(int valor){
		this.contador = valor;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "Cont [contador=" + contador + "]";
	}
}
