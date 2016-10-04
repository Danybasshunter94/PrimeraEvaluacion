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
@WebServlet(name="c", urlPatterns="/Contador")
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
		super.init(config);
		
		ServletContext contexto = this.getServletContext();
		
		Cont contador = new Cont(5);
		contexto.setAttribute("contador", contador);
		
		String parametro = config.getInitParameter("fichero");
		System.out.println(parametro);
		System.out.println(this.getServletContext().getInitParameter("global1"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		//Contador con clase Contador
		if (sesion.isNew()) {
			sesion.setAttribute("clicks", new ArrayList<Click>());
			sesion.setAttribute("contador", new Cont());
		}
		Cont contador =  (Cont) sesion.getAttribute("contador");
		ArrayList<Click> clicks = (ArrayList<Click>) sesion.getAttribute("clicks");
		contador.incrementarContador();
		
		Click click = new Click(new Cont(contador.getContador()));
		clicks.add(click);
		
		//Manejo lista en contexto
		ServletContext contexto = request.getServletContext();
		
		//System.out.println(contexto.getAttribute("contador").toString());
		
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
