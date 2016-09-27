<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba</title>
</head>
<body>
	<%
		Date fecha = new Date();
		Random rnd = new Random();
		String salida = "<p>ID Sesion " + session.getId() + "</p><p>" + fecha + "</p><p>" + rnd.nextInt(6) + "</p><p>";
	%>
	<%=salida%>
	<p>
		<a href="">Recargar</a>
	</p>
	<p>
	<form>
		<input type="submit" value="Recargar" />
	</form>
	</p>
</body>
</html>