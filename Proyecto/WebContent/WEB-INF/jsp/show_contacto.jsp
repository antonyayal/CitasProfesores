<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inscribir alumno de Posgrado</title>
  </head>
<body>
  <h2>Estudiante</h2>
  <table width="80%" border="1" bgcolor=" 73c6b6 ">
  <c:forEach items="${listaestudiantes.estudiantes}" var="estudiante" varStatus="status">
	<tr>
		<td bgcolor=" 3498db "><B>ID Estudiante</b></td> <td>${estudiante.id_estudiante}</td>
	</tr>
	<tr>	
		<td bgcolor=" 3498db "><B>Nombre</b></td><td>${estudiante.nombre}</td>
	</tr>
	<tr>
	    <td bgcolor=" 3498db "><B>Apellido Paterno</b></td><td>${estudiante.apPat}</td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Apellido Materno</b></td><td>${estudiante.apMat}</td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Numero Cuenta</b></td><td>${estudiante.cuenta}</td>
	</tr>
	<tr>
	    <td bgcolor=" 3498db "><B>Correo electronico</b></td><td>${estudiante.correo}</td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Edad Estudiante</b></td><td>${estudiante.edad}</td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Genero</b></td><td>${estudiante.genero}</td>
	</tr>
	<tr>
	    <td bgcolor=" 3498db "><B>Posgrado</b></td><td>${estudiante.posgrado}</td>	
	</tr>
	</c:forEach>
  </table>	
  <br/>
  <input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>