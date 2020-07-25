<?php
	include("./modelo/conexion.php");
	include("./modelo/usuario.class.php");
?>
<?php
	$obj = new Usuario();
?>
<?php
	$data = json_decode($obj->consultas());
	$tiposUsuarios = json_decode($obj->getTiposUsuario());
?>
<?php
	if(isset($_POST['crear'])){
		$obj->nombre = $_POST['nombre'];
		$obj->apellidos = $_POST['apellidos'];
		$obj->nick = $_POST['nick'];
		$obj->email = $_POST['email'];
		$obj->nacimiento = $_POST['nacimiento'];
		$obj->telefono = $_POST['telefono'];
		$obj->direccion = $_POST['direccion'];
		$obj->contrasena = $_POST['contrasena'];
		$obj->tipoUsuario = $_POST['tipoUsuario'];
		$obj->agregar();
		$data = json_decode($obj->consultas());
	}
	if(isset($_POST['modificar'])){
		$obj->id = $_POST['idUsuario'];
		$obj->nombre = $_POST['nombre'];
		$obj->apellidos = $_POST['apellidos'];
		$obj->nick = $_POST['nick'];
		$obj->email = $_POST['email'];
		$obj->nacimiento = $_POST['nacimiento'];
		$obj->telefono = $_POST['telefono'];
		$obj->direccion = $_POST['direccion'];
		$obj->contrasena = $_POST['contrasena'];
		$obj->tipoUsuario = $_POST['tipoUsuario'];
		$obj->modificar();
		$data = json_decode($obj->consultas());
	}
	if(isset($_POST['eliminar'])){
		$obj->id = $_POST['idUsuario'];
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
		 <title>Gestión de usuarios</title>
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
					document.getElementById('crearUsuario').classList.add('visible');
					document.getElementById('cancelButton').classList.add('visible');
					document.getElementById('add').classList.remove('visible');
					document.getElementById('listaUsuarios').classList.remove('visible');
				} else {
					document.getElementById('crearUsuario').classList.remove('visible');
					document.getElementById('cancelButton').classList.remove('visible');
					document.getElementById('add').classList.add('visible');
					document.getElementById('listaUsuarios').classList.add('visible');
				}
			}
			function mostrarEditForm(open, id) {
				if(open) {
					document.getElementById(id).classList.add('visible');
					document.getElementById('cancel'+id).classList.add('visible');
					document.getElementById('add').classList.remove('visible');
					document.getElementById('listaUsuarios').classList.remove('visible');
				} else {
					document.getElementById(id).classList.remove('visible');
					document.getElementById('cancel'+id).classList.remove('visible');
					document.getElementById('add').classList.add('visible');
					document.getElementById('listaUsuarios').classList.add('visible');
				}
			}
		 </script>
	</head>
	<body>
		<div class="container">
			<h3>Lista de usuarios</h3>
			<button id="add" onclick="mostrarForm(true)" class="btn btn-success visible hidden">Crear nuevo usuario</button>
			<form style="padding: 10px" id="crearUsuario" method="POST" class="hidden">
				<div class="form-group col-md-6">
					<label for="nombre">Tipo de usuario</label>
					<select class="custom-select" name="tipoUsuario">
						<?php
							foreach($tiposUsuarios->data as $tipo) {
								echo "<option value='$tipo->idTipoUsuarios'>$tipo->tipoUsuario</option>";
							}
						?>
					</select>
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Nombre</label>
					<input type="text" name="nombre" class="form-control" placeholder="Nombre">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Apellidos</label>
					<input type="text" name="apellidos" class="form-control" placeholder="Apellidos">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Nick de usuario</label>
					<input type="text" name="nick" class="form-control" placeholder="Nick de usuario">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Correo electrónico</label>
					<input type="email" name="email" class="form-control" placeholder="Correo electrónico">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Fecha de nacimiento</label>
					<input type="text" pattern="^\d{4}(\/)(((0)[0-9])|((1)[0-2]))(\/)([0-2][0-9]|(3)[0-1])$" title="Debe ser una fecha AAAA/MM/DD" name="nacimiento" class="form-control" placeholder="AAAA/MM/DD">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre" >Teléfono</label>
					<input type="text" pattern="^([0-9])*$" title="Debe ser un número" name="telefono" class="form-control" placeholder="Teléfono">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Dirección</label>
					<input type="text" name="direccion" class="form-control" placeholder="Dirección">
				</div>
				<div class="form-group col-md-6">
					<label for="nombre">Contraseña</label>
					<input type="password" name="contrasena" class="form-control" placeholder="Contraseña">
				</div>
				<button type="submit" name="crear" class="btn btn-success">Crear usuario</button>
			</form>
			<button id="cancelButton" onclick="mostrarForm(false)" class="btn btn-danger hidden">Cancelar</button>
			<?php 
				foreach($data->data as $item){
					$feTipoUsuario = '';
					foreach($tiposUsuarios->data as $tipo) {
						$feTipoUsuario = $feTipoUsuario."<option value='$tipo->idTipoUsuarios'";
						if($item->tipousuarios_idTipoUsuarios == $tipo->idTipoUsuarios){
							$feTipoUsuario = $feTipoUsuario." selected";
						}
						$feTipoUsuario = $feTipoUsuario.">$tipo->tipoUsuario</option>";
					}
					echo "
						<form style='padding: 10px' id='$item->idUsuarios' method='POST' class='hidden'>
							<input class='hidden' name='idUsuario' value='$item->idUsuarios'>
							<div class='form-group col-md-6'>
								<label for='tipoUsuario'>Tipo de usuario</label>
								<select class='custom-select' name='tipoUsuario'>".
									$feTipoUsuario.
								"</select>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Nombre</label>
								<input type='text' name='nombre' class='form-control' value='$item->nombre'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Apellidos</label>
								<input type='text' name='apellidos' class='form-control' value='$item->apellido'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Nick de usuario</label>
								<input type='text' name='nick' class='form-control' value='$item->nombreUsuario'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Correo electrónico</label>
								<input type='email' name='email' class='form-control' value='$item->email'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Fecha de nacimiento</label>
								<input type='text' name='nacimiento' class='form-control' value='$item->fechaDeNacimiento'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Teléfono</label>
								<input type='text' name='telefono' class='form-control' value='$item->telefono'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Dirección</label>
								<input type='text' name='direccion' class='form-control' value='$item->direccion'>
							</div>
							<div class='form-group col-md-6'>
								<label for='nombre'>Contraseña</label>
								<input type='password' name='contrasena' class='form-control' value='$item->contraseña'>
							</div>
							<button type='submit' name='modificar' class='btn btn-success'>Modificar usuario</button>
						</form>
						<button id='cancel".$item->idUsuarios."' onclick='mostrarEditForm(false, $item->idUsuarios)' class='btn btn-danger hidden'>Cancelar</button>";
				}
			?>
			<table id="listaUsuarios" style="margin-top: 20px" class="table table-striped visible hidden">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Tipo de usuario</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellidos</th>
						<th scope="col">Nick usuario</th>
						<th scope="col">Correo electrónico</th>
						<th scope="col">Fecha de nacimiento</th>
						<th scope="col">Teléfono</th>
						<th scope="col">Dirección</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<?php
						foreach($data->data as $item){
							echo "<tr>
									<th scope='row'>$item->idUsuarios</th>
									<td>$item->tipoUsuario</td>
									<td>$item->nombre</td>
									<td>$item->apellido</td>
									<td>$item->nombreUsuario</td>
									<td>$item->email</td>
									<td>$item->fechaDeNacimiento</td>
									<td>$item->telefono</td>
									<td>$item->direccion</td>
									<td><button onclick='mostrarEditForm(true, $item->idUsuarios)' class='btn btn-info'>Editar</button></td>
									<td>
										<form method='POST'>
											<input class='hidden' name='idUsuario' value='$item->idUsuarios'>
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