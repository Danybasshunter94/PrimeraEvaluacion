package model;

public class ClickContexto {
	private String idSesion;
	private Click click;
	
	public ClickContexto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClickContexto(String idSesion, Click click) {
		super();
		this.idSesion = idSesion;
		this.click = click;
	}

	public String getIdSesion() {
		return idSesion;
	}
	
	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}
	
	public Click getClick() {
		return click;
	}
	
	public void setClick(Click click) {
		this.click = click;
	}

	@Override
	public String toString() {
		return "La sesion con id: " + idSesion + " ha hecho click " + click.getCont().getContador() + " en la fecha " + click.getFecha();
	}
	
	
	
}
