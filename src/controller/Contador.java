package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Click;
import model.Cont;

/**
 * Servlet implementation class Contador
 */
@WebServlet("/Contador")
public class Contador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contador() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("Cargando el server");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		HttpSession sesion = request.getSession();
		if (sesion.getAttribute("clicks") == null && sesion.getAttribute("contador") == null) {
			sesion.setAttribute("clicks", new ArrayList<Click>());
			sesion.setAttribute("contador", new Cont());
		}
		Cont contador =  (Cont) sesion.getAttribute("contador");
		ArrayList<Click> clicks = (ArrayList<Click>) sesion.getAttribute("clicks");
		contador.setContador(contador.getContador() + 1);
		
		clicks.add(new Click(new Cont(contador.getContador() + 1)));
		
		/*Integer contador = (Integer) sesion.getAttribute("contador");
		if (contador == null){
			contador = 0;
		}
		contador++;
		sesion.setAttribute("contador", contador);
		
		ArrayList<Click> clicks = (ArrayList<Click>) sesion.getAttribute("clicks");
		if (clicks == null){
			clicks = new ArrayList<>();
		}
		
		clicks.add(new Click(contador));
		sesion.setAttribute("clicks", clicks);*/
		
		String id = sesion.getId();
		PrintWriter salida = response.getWriter();
		salida.append("<html><body>La id es: " + id +"<br/></body></html>");
		salida.append("<html><body>El contador vale: " + contador + "<br/></body></html>");
		
		
		
		for(Click c: clicks){
			salida.append("<html><body>El click numero " + c.getContador() + " se pulso a fecha de " + c.getFecha() + "<br/></body></html>");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
