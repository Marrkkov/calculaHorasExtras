<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<style>
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 15px;
  height: 330px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Admin</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"
        crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
        crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">

    <!-- Menú superior -->
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="index.html">Start Bootstrap</a>
        <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i
                class="fas fa-bars"></i></button>

        
        <ul class="navbar-nav ml-auto mr-0 mr-md-2">
            <!-- Menú usuario -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Logout</a>
                </div>
            </li>
            <!-- Menú usuario ️¸#-->
        </ul>
    </nav>
    <!-- Menú superior ️¸#-->
    <div id="layoutSidenav">

        <!-- Menú Lateral -->
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Menu</div>
                          <a class="nav-link" href="/">
                            <div class="sb-nav-link-icon"><i class="fa fa-child"></i></div>
                            Home
                        </a>
                        <a class="nav-link" href="/admin">
                            <div class="sb-nav-link-icon"><i class="fa fa-child"></i></div>
                            Administracion
                        </a>
                        <a class="nav-link" href="/cargaReloj">
                            <div class="sb-nav-link-icon"><i class="fa fa-child"></i></div>
                            Carga Reloj Control
                        </a>
                    </div>
              
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Reconocido como:</div>
                    <c:out value="${correo}"></c:out>
                </div>
            </nav>
        </div>
        <!-- Menú superior ️¸#-->

        <!-- Cuerpo de la aplicación -->
        <div id="layoutSidenav_content">
            <main>

	
		<div class="row my-5">
			<div class="col-2"></div>
			<div class="col-8">
				<!-- Formulario -->
				<div>

					<c:if test="${not empty mensaje}">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>Información</strong> ${mensaje}
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
	
<div class="row">

  <div class="column" style="background-color:#aaa;">
   
<h4>Agregar Trabajador</h4>
					<hr>
					<form id="formulario" action="<c:url value='/usuarios'/>" method="post"
						enctype="multipart/form-data">
						
						<div class="row">

  						<div class="column">
  						
						<div class="form-group col-12">
							<label for="marca">Nombre</label> <input id="nombre" name="nombre"
								type="text" class="form-control" />
						</div>

						<div class="form-group col-12">
							<label for="modelo">Rut</label> <input id="correo"
								name="correo" type="email" class="form-control" />
						</div>

						<button id="boton" type="submit" class="btn btn-primary">Ingresar</button>
						
						</div>
						</div>
						
					</form>
  </div>
  <div class="column" style="background-color:#bbb;">
   
   <h4>Agregar Hora Extra</h4>
				<hr>
				<form id="formulario" action="<c:url value='/horaExtra'/>" method="post"
						enctype="multipart/form-data">
						
						<div class="row">

  						<div class="column">
						<div class="form-group col-12">
							<label for="marca"> Rut  </label> <input id="rut" name="rut"
								type="text" class="form-control" />
						</div>

						<div class="form-group col-12">
							<label for="modelo">Fecha</label> <input id="fecha"
								name="fecha" type="text" class="form-control" />
						</div>
						<button id="boton" type="submit" class="btn btn-primary">Ingresar</button>
						
						</div>
						<div class="column">
						<div class="form-group col-12">
							<label for="modelo">Hora Entrada</label> <input id="horaEntrada"
								name="horaEntrada" type="text" class="form-control" />
						</div>
						
						<div class="form-group col-12">
							<label for="modelo">Hora Salida</label> <input id="horaSalida"
								name="horaSalida" type="text" class="form-control" />
						</div>
						</div>

						
						</div>
						
						
					</form>
  </div>
</div>
				<!-- Formulario # -->
				<hr>
				<!-- TABLA DE AUTOMOVIL -->
					<h3>Resumen Horas Extras</h3>
					<hr>
					<table id="tablaAutos" class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nombre</th>
								<th scope="col">Rut</th>
								<th scope="col">Mes</th>
								<th scope="col">Horas Extras Totales</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nombre</th>
								<th scope="col">Rut</th>
								<th scope="col">Mes</th>
								<th scope="col">Horas Extras Totales</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach var="usuario" items="${usuarios}">
								<tr>
									<th scope="row">${usuario.id}</th>
									<td>${usuario.nombre}</td>
									<td>${usuario.correo}</td>
									<td>${usuario.contrasenia}</td>
									<td><img width="100" height="100" src="<c:url value='${usuario.urlImagen}'></c:url>" class="rounded" alt="${usuario.urlImagen}" /></td>
									<td>
									<a href='javascript:actualizar(${usuario.toJson()})'>Actualizar</a> | 
									<a href='javascript:eliminar(${usuario.toJson()})'>Eliminar</a>
									
									</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				<!-- TABLA DE AUTOMOVIL # -->
			</div>
			<div class="col-2"></div>
		</div>
	</div>

	<!-- bootstrap -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<!-- bootstrap # -->

	<!-- javascript - data table -->
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablaAutos').DataTable();
		});
	</script>
	<!-- javascript - # data table -->
	
	<script type="text/javascript">
		const eliminar = (usuario) => {
			if(!confirm("seguro que desea eliminar usuario id: " + usuario.correo))
				return

			const baseUrl = window.location.origin
			window.location.href = baseUrl + '/usuarios/eliminar?id=' + usuario.id
		}
		
		const actualizar = (usuario) => {
			// capturamos el formulario
			const formulario = document.querySelector('#formulario')
			formulario.nombre.value = usuario.nombre
			formulario.correo.value = usuario.correo

			// eliminamos los imputs si existen, si existe
			// será capturado por su id
			const input001 = formulario.elementoGenerado001
			if(input001)
				input001.remove();

			const input002 = formulario.elementoGenerado002
			if(input002)
				input002.remove();

			// creamos dos input escondidos, con el resto
			// de los atributos que necesitaremos para
			// la actualización
			const input_id = document.createElement('input')
			input_id.type = 'hidden'
			input_id.name = 'id'
			input_id.value = usuario.id
			input_id.id = 'elementoGenerado001'

			const input_url_imagen = document.createElement('input')
			input_url_imagen.type = 'hidden'
			input_url_imagen.name = 'urlImagen'
			input_url_imagen.value = usuario.urlImagen
			input_url_imagen.id = 'elementoGenerado002'

			// agregamos estos campos creados al formulario
			formulario.appendChild(input_id);
			formulario.appendChild(input_url_imagen);
			// adaptamos el botón a una actualización
			// lo capturamos por su id
			formulario.boton.textContent = 'Actualizar'
			// cambiamos el método para que vaya a actualizar
			formulario.action = '/usuarios/actualizar'
		}

	</script>


            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2020</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <!-- Cuerpo de la aplicación ️¸#-->
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>

    <!-- dataTable a español -->
    <script>
        const cdn = "//cdn.datatables.net/plug-ins/1.10.21/i18n/Spanish.json"
        $(document).ready(function () {
            $('#dataTable').DataTable({
                "language": {
                    "url": cdn
                }
            });
        });
    </script>
    <!-- dataTable a español #-->
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/datatables-demo.js"></script>

</body>

</html>