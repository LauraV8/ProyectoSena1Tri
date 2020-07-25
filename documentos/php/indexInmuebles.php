<?php
	include("./modelo/conexion.php");
	include("./modelo/inmuebles.class.php");
?>
<?php
	$obj = new Inmuebles();
?>
<?php
	$data = json_decode($obj->consultas());
	$tipoInmuebles = json_decode($obj->getTiposInmueble());
	$municipios = json_decode($obj->getCiudades());
?>
<?php
	if(isset($_POST['crear'])){
		$obj->nombre = $_POST['nombre'];
		$obj->precioAlquiler = $_POST['precioAlquiler'];
		$obj->descripcion = $_POST['descripcion'];
		$obj->tipoInmueble = $_POST['tipoInmueble'];
		$obj->idCiudad = $_POST['idCiudad'];
		$obj->agregar();
		$data = json_decode($obj->consultas());
	}
	if(isset($_POST['modificar'])){
		$obj->id = $_POST['idInmuebles'];
		$obj->nombre = $_POST['nombre'];
		$obj->precioAlquiler = $_POST['precioAlquiler'];
		$obj->descripcion = $_POST['descripcion'];
		$obj->tipoInmueble = $_POST['tipoInmueble'];
		$obj->idCiudad = $_POST['idCiudad'];
		$obj->modificar();
		$data = json_decode($obj->consultas());
	}
	if(isset($_POST['eliminar'])){
		$obj->id = $_POST['idInmuebles'];
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
		 <title>Gestión de Inmuebles</title>
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
					document.getElementById('crearInmueble').classList.add('visible');
					document.getElementById('cancelButton').classList.add('visible');
					document.getElementById('add').classList.remove('visible');
					document.getElementById('listaInmuebles').classList.remove('visible');
				} else {
					document.getElementById('crearInmueble').classList.remove('visible');
					document.getElementById('cancelButton').classList.remove('visible');
					document.getElementById('add').classList.add('visible');
					document.getElementById('listaInmuebles').classList.add('visible');
				}
			}
			function mostrarEditForm(open, id) {
				if(open) {
					document.getElementById(id).classList.add('visible');
					document.getElementById('cancel'+id).classList.add('visible');
					document.getElementById('add').classList.remove('visible');
					document.getElementById('listaInmuebles').classList.remove('visible');
				} else {
					document.getElementById(id).classList.remove('visible');
					document.getElementById('cancel'+id).classList.remove('visible');
					document.getElementById('add').classList.add('visible');
					document.getElementById('listaInmuebles').classList.add('visible');
				}
			}
		 </script>
	</head>
	<body>
		<div class="container">
			<h3>Inmuebles</h3>
			<button id="add" onclick="mostrarForm(true)" class="btn btn-success visible hidden">Crear nuevo Inmueble</button>
			<form style="padding: 10px" id="crearInmueble" method="POST" class="hidden">
				<div class="form-group col-md-6">
					<label for="nombre">Nombre</label>
					<input type="text" name="nombre" class="form-control" placeholder="Nombre">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Precio Alquiler</label>
					<input type="text" name="precioAlquiler" class="form-control" placeholder="Precio Alquiler">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Descripcion</label>
					<input type="text" name="descripcion" class="form-control" placeholder="Descripcion">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Tipo de inmueble</label>
					<select class="custom-select" name="tipoInmueble">
						<?php
							foreach($tipoInmuebles->data as $tipo) {
								echo "<option value='$tipo->idTipoInmuebles'>$tipo->tipoInmueble</option>";
							}
						?>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Municipio</label>
					<select class="custom-select" name="idCiudad">
						<?php
							foreach($municipios->data as $municipio) {
								echo "<option value='$municipio->idCiudades'>$municipio->nombreCiudad</option>";
							}
						?>
					</select>
				</div>
				<button type="submit" name="crear" class="btn btn-success">Crear Inmueble</button>
			</form>
			<button id="cancelButton" onclick="mostrarForm(false)" class="btn btn-danger hidden">Cancelar</button>
			<?php 
				foreach($data->data as $item){
					$feTipoInmuebles = '';
					$feMunicipios = '';
					foreach($tipoInmuebles->data as $tipo) {
						$feTipoInmuebles = $feTipoInmuebles."<option value='$tipo->idTipoInmuebles'";
						if($item->tipoinmuebles_idTipoInmuebles == $tipo->idTipoInmuebles){
							$feTipoInmuebles = $feTipoInmuebles." selected";
						}
						$feTipoInmuebles = $feTipoInmuebles.">$tipo->tipoInmueble</option>";
					}
					foreach($municipios->data as $municipio) {
						$feMunicipios = $feMunicipios."<option value='$municipio->idCiudades'";
						if($item->ciudades_idCiudades == $municipio->idCiudades){
							$feMunicipios = $feMunicipios." selected";
						}
						$feMunicipios = $feMunicipios.">$municipio->nombreCiudad</option>";
					}
					echo "
						<form style='padding: 10px' id='$item->idInmuebles' method='POST' class='hidden'>
							<input class='hidden' name='idInmuebles' value='$item->idInmuebles'>
							<div class='form-group col-md-6'>
								<label for='nombre'>Nombre</label>
								<input type='text' name='nombre' class='form-control' value='$item->nombre'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Precio alquiler</label>
								<input type='text' name='precioAlquiler' class='form-control' value='$item->precioAlquiler'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Descripcion</label>
								<input type='text' name='descripcion' class='form-control' value='$item->descripcion'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Tipo de inmueble</label>
								<select class='custom-select' name='tipoInmueble'>".
									$feTipoInmuebles.
								"</select>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Municipio</label>
								<select class='custom-select' name='idCiudad'>".
									$feMunicipios.
								"</select>
							</div>
							<button type='submit' name='modificar' class='btn btn-success'>Modificar inmuebles</button>
						</form>
						<button id='cancel".$item->idInmuebles."' onclick='mostrarEditForm(false, $item->idInmuebles)' class='btn btn-danger hidden'>Cancelar</button>";
				}
			?>
			<table id="listaInmuebles" style="margin-top: 20px" class="table table-striped visible hidden">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Tipo de inmueble</th>
						<th scope="col">Nombre</th>
						<th scope="col">Precio Alquiler</th>
						<th scope="col">Municipio</th>
						<th scope="col">Descripcion</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<?php
						foreach($data->data as $item){
							echo "<tr>
									<th scope='row'>$item->idInmuebles</th>
									<td>$item->tipoInmueble</td>
									<td>$item->nombre</td>
									<td>$item->precioAlquiler</td>
									<td>$item->nombreCiudad</td>
									<td>$item->descripcion</td>
									<td><button onclick='mostrarEditForm(true, $item->idInmuebles)' class='btn btn-info'>Editar</button></td>
									<td>
										<form method='POST'>
											<input class='hidden' name='idInmuebles' value='$item->idInmuebles'>
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