<%@page import="model.ClickContexto"%>
<%@page import="model.Click"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Clicks y contexto de sesion.
	<table style="border:1px solid black">
		<%
			ArrayList<Click> clicksSesion = (ArrayList<Click>) session.getAttribute("clicks");
			for (int i = 0; i < clicksSesion.size(); i++) {
				String fecha = clicksSesion.get(i).getFecha().toString();
				int contador = clicksSesion.get(i).getCont().getContador();
		%>

		<tr>
			<td><%=contador%></td>
			<td><%=fecha%></td>
		</tr>
		<%
			}
		%>

	</table>
	<br/>
	<table style="border:1px solid black">
		<%
			ArrayList<ClickContexto> clicksContexto = (ArrayList<ClickContexto>) application.getAttribute("clicks");
			for (int i = 0; i < clicksContexto.size(); i++) {
		%>

		<tr>
			<td><%=clicksContexto.get(i).getIdSesion()%></td>
			<td><%=clicksContexto.get(i).getClick().getFecha().toString()%></td>
			<td><%=clicksContexto.get(i).getClick().getCont().getContador()%></td>
		</tr>
		<%
			}
		%>

	</table>
	
</body>
</html>
