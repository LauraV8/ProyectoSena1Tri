<?php
	include("./modelo/conexion.php");
	include("./modelo/reservas.class.php");
?>
<?php
    $obj = new Reservas();
?>
<?php
	$data = json_decode($obj->consultas());
	$estadoReservas = json_decode($obj->getEstados());
	$inmuebles = json_decode($obj->getInmuebles());
?>
<?php
	if(isset($_POST['crear'])){
		$obj->estancia = $_POST['estancia'];
		$obj->cantidadDePersonas = $_POST['cantidadDePersonas'];
		$obj->ingreso = $_POST['ingreso'];
		$obj->salida = $_POST['salida'];
        $obj->estadoReserva = $_POST['estadoReserva'];
        $obj->idInmueble = $_POST['idInmueble'];
		$obj->agregar();
		$data = json_decode($obj->consultas());
	}
	if(isset($_POST['modificar'])){
		$obj->id = $_POST['idReservas'];
		$obj->estancia = $_POST['estancia'];
		$obj->cantidadDePersonas = $_POST['cantidadDePersonas'];
		$obj->ingreso = $_POST['ingreso'];
		$obj->salida = $_POST['salida'];
        $obj->estadoReserva = $_POST['estadoReserva'];
        $obj->idInmueble = $_POST['idInmueble'];
		$obj->modificar();
		$data = json_decode($obj->consultas());
	}
	if(isset($_POST['eliminar'])){
		$obj->id = $_POST['idReservas'];
		$obj->eliminar();
		$data = json_decode($obj->consultas());
	}
?>

<!DOCTYPE>
<html lang="es">
	<head>
		 <meta charset="utf-8">
		 <meta name="viewport" content="css, php, html, javascript">
		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		 <title>Gestión de Reservas</title>
		 <style>
		 	.container {
				padding-top: 50px;
			}
		 	.hidden {
				display: none;
			}
			.visible {
				display: block !important;
			}
		 </style>
		 <script>
		 	function mostrarForm(open) {
				if(open) {
					document.getElementById('crearReserva').classList.add('visible');
					document.getElementById('cancelButton').classList.add('visible');
					document.getElementById('add').classList.remove('visible');
					document.getElementById('listaReservas').classList.remove('visible');
				} else {
					document.getElementById('crearRserva').classList.remove('visible');
					document.getElementById('cancelButton').classList.remove('visible');
					document.getElementById('add').classList.add('visible');
					document.getElementById('listaReservas').classList.add('visible');
				}
			}
			function mostrarEditForm(open, id) {
				if(open) {
					document.getElementById(id).classList.add('visible');
					document.getElementById('cancel'+id).classList.add('visible');
					document.getElementById('add').classList.remove('visible');
					document.getElementById('listaReservas').classList.remove('visible');
				} else {
					document.getElementById(id).classList.remove('visible');
					document.getElementById('cancel'+id).classList.remove('visible');
					document.getElementById('add').classList.add('visible');
					document.getElementById('listaReservas').classList.add('visible');
				}
			}
		 </script>
	</head>
	<body>
		<div class="container">
			<h3>Reservas</h3>
			<button id="add" onclick="mostrarForm(true)" class="btn btn-success visible hidden">Crear nueva reserva</button>
			<form style="padding: 10px" id="crearReserva" method="POST" class="hidden">
				<div class="form-group col-md-6">
					<label for="estancia">Estancia</label>
					<input type="text" name="estancia" class="form-control" placeholder="Estancia">
				</div>
				<div class="form-group col-md-6">
					<label for="cantidadDePersonas">Cantidad de personas</label>
					<input type="number" name="cantidadDePersonas" class="form-control" placeholder="Cantidad de personas">
				</div>
				<div class="form-group col-md-6">
					<label for="ingreso">Ingreso</label>
					<input type="text" pattern="^\d{4}(\/)(((0)[0-9])|((1)[0-2]))(\/)([0-2][0-9]|(3)[0-1])$" title="Debe ser una fecha AAAA/MM/DD" name="ingreso" class="form-control" placeholder="Fecha ingreso">
				</div>
                <div class="form-group col-md-6">
					<label for="salida">Salida</label>
					<input type="text" pattern="^\d{4}(\/)(((0)[0-9])|((1)[0-2]))(\/)([0-2][0-9]|(3)[0-1])$" title="Debe ser una fecha AAAA/MM/DD" name="salida" class="form-control" placeholder="Fecha salida">
				</div>
				<div class="form-group col-md-6">
					<label for="estadoReserva">Estado de la reserva</label>
					<select class="custom-select" name="estadoReserva">
						<?php
							foreach($estadoReservas->data as $estado) {
								echo "<option value='$estado->idEstadoReservas'>$estado->nombreEstado</option>";
							}
						?>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="inmueble">Inmueble</label>
					<select class="custom-select" name="idInmueble">
						<?php
							foreach($inmuebles->data as $inmueble) {
								echo "<option value='$inmueble->idInmuebles'>$inmueble->nombre</option>";
							}
						?>
					</select>
				</div>
				<button type="submit" name="crear" class="btn btn-success">Crear Reserva</button>
			</form>
			<button id="cancelButton" onclick="mostrarForm(false)" class="btn btn-danger hidden">Cancelar</button>
			<?php 
				foreach($data->data as $item){
					$feEstadoReserva = '';
					$feInmueble = '';
					foreach($estadoReservas->data as $estado) {
						$feEstadoReserva = $feEstadoReserva."<option value='$estado->idEstadoReservas'";
						if($item->estadoreservas_idEstadoReservas == $estado->idEstadoReservas){
							$feEstadoReserva = $feEstadoReserva." selected";
						}
						$feEstadoReserva = $feEstadoReserva.">$estado->nombreEstado</option>";
					}
					foreach($inmuebles->data as $inmueble) {
						$feInmueble = $feInmueble."<option value='$inmueble->idInmuebles'";
						if($item->inmuebles_idInmuebles == $inmueble->idInmuebles){
							$feInmueble = $feInmueble." selected";
						}
						$feInmueble = $feInmueble.">$inmueble->nombre</option>";
					}
					echo "
						<form style='padding: 10px' id='$item->idReservas' method='POST' class='hidden'>
							<input class='hidden' name='idReservas' value='$item->idReservas'>
							<div class='form-group col-md-6'>
								<label for='estancia'>Estancia</label>
								<input type='text' name='estancia' class='form-control' value='$item->estancia'>
							</div>
							<div class='form-group col-md-6'>
								<label for='cantidadDePersonas'>Cantidad de personas</label>
								<input type='text' name='cantidadDePersonas' class='form-control' value='$item->cantidadDePersonas'>
							</div>
							    <div class='form-group col-md-6'>
					            <label for='ingreso'>Ingreso</label>
					            <input type='text' pattern='^\d{4}(\/)(((0)[0-9])|((1)[0-2]))(\/)([0-2][0-9]|(3)[0-1])$' title='Debe ser una fecha AAAA/MM/DD' name='ingreso' class='form-control' value='$item->ingreso'>
                            </div>
                                <div class='form-group col-md-6'>
					            <label for='salida'>Salida</label>
					            <input type='text' pattern='^\d{4}(\/)(((0)[0-9])|((1)[0-2]))(\/)([0-2][0-9]|(3)[0-1])$' title='Debe ser una fecha AAAA/MM/DD' name='salida' class='form-control' value='$item->salida'>
				            </div>
							<div class='form-group col-md-6'>
								<label for='estadoReserva'>Estado de la reserva</label>
								<select class='custom-select' name='estadoReserva'>".
									$feEstadoReserva.
								"</select>
							</div>
							<div class='form-group col-md-6'>
								<label for='inmueble'>Inmueble</label>
								<select class='custom-select' name='idInmueble'> value='$item->inmuebles_idInmuebles'".
									$feInmueble.
								"</select>
							</div>
							<button type='submit' name='modificar' class='btn btn-success'>Modificar reserva</button>
						</form>
						<button id='cancel".$item->idReservas."' onclick='mostrarEditForm(false, $item->idReservas)' class='btn btn-danger hidden'>Cancelar</button>";
				}
			?>
			<table id="listaReservas" style="margin-top: 20px" class="table table-striped visible hidden">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Estancia</th>
						<th scope="col">Cantidad de personas</th>
						<th scope="col">Ingreso</th>
						<th scope="col">Salida</th>
						<th scope="col">Estado</th>
						<th scope="col">Inmueble</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<?php
						foreach($data->data as $item){
							echo "<tr>
									<th scope='row'>$item->idReservas</th>
									<td>$item->estancia</td>
									<td>$item->cantidadDePersonas</td>
									<td>$item->ingreso</td>
									<td>$item->salida</td>
                                    <td>$item->nombreEstado</td>
                                    <td>$item->nombre</td>
                                    <td>$item->nombreUsuario</td>

									<td><button onclick='mostrarEditForm(true, $item->idReservas)' class='btn btn-info'>Editar</button></td>
									<td>
										<form method='POST'>
											<input class='hidden' name='idReservas' value='$item->idReservas'>
											<button name='eliminar' type='submit' class='btn btn-danger'>Eliminar</button>
										</form>
									</td>
								</tr>";
						}
					?>
				</tbody>
			</table>
		</div>
	</body>
</html>