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
<h2>Inscribir alumno de Posgrado</h2>
<form:form method="post" action="save.html" modelAttribute="listaestudiantes">
	<table border="1" bgcolor=" 73c6b6 ">
	  <c:forEach items="${listaestudiantes.estudiantes}" var="estudiante" varStatus="status">
	<tr>
		<td bgcolor=" 3498db "><B>ID Estudiante</b></td> <td><input name="estudiantes[${status.index}].id_estudiante" value="${estudiante.id_estudiante}"/></td>
	</tr>
	<tr>	
		<td bgcolor=" 3498db "><B>Nombre</b></td> <td><input name="estudiantes[${status.index}].nombre" value="${estudiante.nombre}"/></td>
	</tr>
	<tr>
	    <td bgcolor=" 3498db "><B>Apellido Paterno</b></td><td><input name="estudiantes[${status.index}].apPat" value="${estudiante.apPat}"/></td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Apellido Materno</b></td><td><input name="estudiantes[${status.index}].apMat" value="${estudiante.apMat}"/></td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Numero Cuenta</b></td><td><input name="estudiantes[${status.index}].cuenta" value="${estudiante.cuenta}"/></td>
	</tr>
	<tr>
	    <td bgcolor=" 3498db "><B>Correo electronico</b></td><td><input name="estudiantes[${status.index}].correo" value="${estudiante.correo}"/></td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Edad Estudiante</b></td><td><input name="estudiantes[${status.index}].edad" value="${estudiante.edad}"/></td>
	</tr>
	<tr>
		<td bgcolor=" 3498db "><B>Genero</b></td><td><input name="estudiantes[${status.index}].genero" value="${estudiante.genero}"/></td>
	</tr>
	<tr>
	    <td bgcolor=" 3498db "><B>Posgrado</b></td><td><input name="estudiantes[${status.index}].posgrado" value="${estudiante.posgrado}"/></td>	
	</tr>
	</c:forEach>
</table>	
<br/>
<input type="submit" value="Save" />	
</form:form>
</body>
</html>