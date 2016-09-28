<%@page import="model.Cont"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Click"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contador</title>
</head>
<body>
<%-- 	<%
		Integer contador = (Integer) session.getAttribute("contador");
		ArrayList<Click> clicks = (ArrayList<Click>) session.getAttribute("clicks");

		if (contador == null) {
			contador = 0;
			clicks = new ArrayList<Click>();
		}

		contador++;
		clicks.add(new Click(contador));

		session.setAttribute("contador", contador);
		session.setAttribute("clicks", clicks);
		out.println(contador + "<br/>");
		for (Click c : clicks) {
			out.println("El click numero " + c.getContador() + " se pulso a fecha de " + c.getFecha() + "<br/>");
		}
	%> --%>
	<%
		if (session.getAttribute("clicks") == null && session.getAttribute("contador") == null) {
			session.setAttribute("clicks", new ArrayList<Click>());
			session.setAttribute("contador", new Cont());
		}
		Cont contador = (Cont) session.getAttribute("contador");
		ArrayList<Click> clicks = (ArrayList<Click>) session.getAttribute("clicks");
		contador.setContador(contador.getContador() + 1);

		clicks.add(new Click(new Cont(contador.getContador())));
		out.println(contador.getContador() + "<br/>");
		for (Click c : clicks) {
			out.println("El click numero " + c.getCont().getContador() + " se pulso a fecha de " + c.getFecha() + "<br/>");
		}
	%>

	<br />
</body>
</html>