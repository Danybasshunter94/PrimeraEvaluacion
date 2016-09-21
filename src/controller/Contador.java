package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Integer contador = (Integer) sesion.getAttribute("contador");
		if (contador == null) {
			contador = 0;
		}
		contador++;
		sesion.setAttribute("contador", contador);
		String id = sesion.getId();
		PrintWriter salida = response.getWriter();
		PrintWriter boton = response.getWriter();
		boton.append(
				"<a href=\"http://192.168.203.223:8080/PrimeraEvaluacion/Contador\">Pusla aqui para aumentar el contador</a><br/>");
		salida.append("El contador vale: " + contador + "</br> La id es = " + id);
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
