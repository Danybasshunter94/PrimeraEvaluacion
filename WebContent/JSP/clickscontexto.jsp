<%@page import="model.ClickContexto"%>
<%@page import="model.Click"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Click Contexto</title>
<style>
body {
	text-align: center;
}

table {
	margin: auto;
}

table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}
.sesion {
	background-color: lightgreen;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="5">Clicks y contexto de sesion</td>
		</tr>
		<tr>
			<td colspan="5">Tu id de sesion actual es: <%=session.getId()%></td>
		</tr>
		<tr>
			<td colspan="2">Sesion</td>
			<td colspan="3">Contexto</td>
		</tr>
		<tr>
			<td>Contador de Sesion</td>
			<td>Fecha de Sesion</td>
			<td>ID Sesion Contexto</td>
			<td>Contador Contexto</td>
			<td>Fecha Contexto</td>
		</tr>
		<%
			ArrayList<Click> clicksSesion = (ArrayList<Click>) session.getAttribute("clicks");
			ArrayList<ClickContexto> clicksContexto = (ArrayList<ClickContexto>) application.getAttribute("clicks");
			for (int i = 0; i < clicksContexto.size(); i++) {
				String fechaSesion;
				String contadorSesion;
				String idSesionContexto = clicksContexto.get(i).getIdSesion();
				String fechaContexto = clicksContexto.get(i).getClick().getFecha().toString();
				int contadorContexto = clicksContexto.get(i).getClick().getCont().getContador();
				String clase;
				if (i < clicksSesion.size()) {
					fechaSesion = clicksSesion.get(i).getFecha().toString();
					contadorSesion = clicksSesion.get(i).getCont().getContador() + "";
				} else {
					fechaSesion = "";
					contadorSesion = "";
				}
		%>

		<tr>
			<td><%=contadorSesion%></td>
			<td><%=fechaSesion%></td>
			<%
				if (idSesionContexto.equals(session.getId())) {
					clase = "class=\"sesion\"";
				} else {
					clase = "";
				}
			%>
			<td <%=clase%>><%=idSesionContexto%></td>
			<td <%=clase%>><%=contadorContexto%></td>
			<td <%=clase%>><%=fechaContexto%></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>
