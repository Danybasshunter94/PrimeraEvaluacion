package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import model.Click;
import model.ClickContexto;
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
		
		
		
		HttpSession sesion = request.getSession();
		
		//Contador con clase Contador
		if (sesion.getAttribute("clicks") == null && sesion.getAttribute("contador") == null) {
			sesion.setAttribute("clicks", new ArrayList<Click>());
			sesion.setAttribute("contador", new Cont());
		}
		Cont contador =  (Cont) sesion.getAttribute("contador");
		ArrayList<Click> clicks = (ArrayList<Click>) sesion.getAttribute("clicks");
		contador.setContador(contador.getContador() + 1);
		
		Click click = new Click(new Cont(contador.getContador()));
		clicks.add(click);
		
		//Manejo lista en contexto
		ServletContext contexto = request.getServletContext();
		
		if(contexto.getAttribute("clicks") == null){
			contexto.setAttribute("clicks", new ArrayList<ClickContexto>());
		}
		
		ArrayList<ClickContexto> clicksContexto = (ArrayList<ClickContexto>) contexto.getAttribute("clicks");
		ClickContexto clickContexto = new ClickContexto(sesion.getId(), click);
		clicksContexto.add(clickContexto);
		
		//Cedes el control al JSP (vista)
		request.getRequestDispatcher("/JSP/clickscontexto.jsp").forward(request, response);
		
		//Contador con Integer
	/*	Integer contador = (Integer) sesion.getAttribute("contador");
		ArrayList<Click> clicks = (ArrayList<Click>) sesion.getAttribute("clicks");
		
		if (contador == null){
			contador = 0;
			clicks = new ArrayList<>();
		}
		
		contador++;
		clicks.add(new Click(contador));
		
		sesion.setAttribute("contador", contador);		
		sesion.setAttribute("clicks", clicks);
		*/
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
