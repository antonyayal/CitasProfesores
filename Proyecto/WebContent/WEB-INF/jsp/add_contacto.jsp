<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">

<title>Sistema para Agendar citas</title>
<style>
	.error { 
		color: red; font-weight: bold; 
	}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<head>
<script src="jquery/jquery.min.js"></script>
<!---- jquery link local dont forget to place this in first than other script or link or may not work ---->

<link rel="stylesheet" href="css/bootstrap.min.css">
<!---- boostrap.min link local ----->

<link rel="stylesheet" href="css/style.css">
<!---- boostrap.min link local ----->

<script src="js/bootstrap.min.js"></script>
<!---- Boostrap js link local ----->

<link rel="icon" href="images/icon.png" type="image/x-icon" />
<!---- Icon link local ----->

<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<!---- Font awesom link local ----->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css" />
</head>

<body>
	<div class="container-fluid">
		<div class="container">
			<h2 class="text-center" id="title">Sistema para agendar taller
				de regularizaci�n</h2>
			<p class="text-center">
				<small id="passwordHelpInline" class="text-muted"> Posgrado
					de Ciencia e Ingenier�a de la Computaci�n</small>
			</p>
			<hr>
			<div class="row">
				<div class="col-md-5">
					<form role="form" method="post" action="agregar_usuario.html"
						modelAttribute="usuario">
						<fieldset>
							<p class="text-uppercase pull-center">�Registrate!</p>
							<div class="form-group">
								<input type="text" name="nombre" id="nombre"
									class="form-control input-lg" placeholder="Nombre" required>
							</div>
							<div class="form-group">
								<input type="text" name="apellido1" id="apellido1"
									class="form-control input-lg" placeholder="Apellido Paterno"
									required>
							</div>
							<div class="form-group">
								<input type="text" name="apellido2" id="apellido2"
									class="form-control input-lg" placeholder="Apellido Materno"
									required>
							</div>

							<div class="form-group">
								<p class="text-uppercase pull-center">Facultad</p>
								<div class="form-group">
									<select name="facultad" id="facultad"
										class="form-control input-lg">
										<option value="Ciencias">Ciencias</option>
										<option value="Ingenieria">Ingenieria</option>
										<option value="IIMAS">IIMAS</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div class="form-group">

									<select name="esProfesor" id="esProfesor"
										class="form-control input-lg" onchange="carg(this);">
										<option value="0" selected>Alumno</option>
										<option value="1">Profesor</option>
									</select>

								</div>
								<div class="form-group">

									<input type="text" name="rfc" id="rfc"
										class="form-control input-lg" placeholder="RFC"
										disabled="true">
								</div>

								<div class="form-group">
									<p class="text-uppercase pull-center">Departamento</p>
									<div class="form-group">
										<select name="departamento" id="departamento"
											class="form-control input-lg" disabled="true">
											<option value="Matematicas">Matematicas</option>
											<option value="Fisica">Fisica</option>
											<option value="Computacion">Computacion</option>
										</select>
									</div>
								</div>
								<div class="form-group"></div>

								<div class="form-group">
									<input type="text" name="nCuenta" id="nCuenta"
										class="form-control input-lg" placeholder="No. Cuenta">
								</div>
								<div class="form-group">
									<input type="text" name="carrera" id="carrera"
										class="form-control input-lg" placeholder="Carrera">
								</div>
								<script type="text/javascript">
									function carg(elemento) {
										d = elemento.value;
										var esProfesor = document
												.getElementById('esProfesor');
										var rfc = document
												.getElementById('rfc');
										var departamento = document
												.getElementById('departamento');
										var nCuenta = document
												.getElementById('nCuenta');
										var carrera = document
												.getElementById('carrera');
										if (d == "0") {
											nCuenta.disabled = false;
											carrera.disabled = false;
											rfc.disabled = true;//se desactivan los campos
											departamento.disabled = true;
											nCuenta.required = required;
											carrera.required = required;
										} else {
	
									nCuenta.disabled = true;
											carrera.disabled = true;
											rfc.disabled = false;//se desactivan los campos
											departamento.disabled = false;
										}
									}
								</script>
							</div>
							<div class="form-group">
								<input type="email" name="email" id="email"
									class="form-control input-lg" placeholder="Email" required>
								<small id="emailHelp" class="form-text text-muted">No
									compartiremos tu correo con nadie.</small>
							</div>
							<div class="form-group">
								<input type="password" name="password" id="password"
									class="form-control input-lg" placeholder="Contrase�a" 	min="8" max="20" required>
								<small id="passwordHelpBlock" class="form-text text-muted">Tu contrase�a debe tener de
									8-20 caracteres sin espacios.</small>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input type="checkbox"
									class="form-check-input"> Aceptar t�rminos y
									condiciones del Aviso de Privacidad.
								</label>
							</div>
							<div>
								<input type="submit" class="btn btn-lg btn-primary"
									value="Registrar">
							</div>
						</fieldset>
					</form>
				</div>

				<div class="col-md-2">
					<!-------null------>
				</div>

				<div class="col-md-5">
					<form role="form" method="post" action="ingresar.html"
						modelAttribute="login">
						<fieldset>
							<p class="text-uppercase">Login</p>

							<div class="form-group">
								<input type="email" name="email" id="email"
									class="form-control input-lg" placeholder="E-mail" required>
							</div>
							<div class="form-group">
								<input type="password" name="password" id="password"
									class="form-control input-lg" placeholder="Contrase�a" required>
									<errors path="password" cssClass="error"/>
							</div>
							<div>
								<input type="submit" class="btn btn-lg btn-primary"
									value="Login">
							</div>

						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<p class="text-center">
			<small id="passwordHelpInline" class="text-muted">
				Developer:Antonio Ayala & Fernando S�nchez PCIC UNAM @2019 </small>
		</p>
	</div>
</body>



</html>