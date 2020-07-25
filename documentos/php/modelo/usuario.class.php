<?php 
	class Usuario{

		public $id;
		public $nombre;
		public $apellidos;
		public $nick;
		public $email;
		public $nacimiento;
		public $telefono;
		public $direccion;
		public $contrasena;
		public $tipoUsuario;

		function getTiposUsuario() {
			$c = new Conexion();
			$cone = $c->conectar();
			$sql = "select * from tipousuarios";
			$query = mysqli_query($cone,$sql);
			$data = json_encode(mysqli_fetch_all($query, MYSQLI_ASSOC));
			if($data){
				return '{"data":' . $data . '}';
			} else {
				echo "<script> alert('error')</script>";
			}
		}
			
		function agregar(){
			$c = new Conexion();
			$cone = $c->conectar();
			$insertar = "insert into usuarios values(null, '$this->nombre', '$this->apellidos', '$this->nick', '$this->email', '$this->nacimiento', '$this->telefono', '$this->direccion', '$this->contrasena', '$this->tipoUsuario')";
			$query = mysqli_query($cone,$insertar);
			echo "<script> alert('usuario creado correctamente')</script>";
		}
		
		function consultas(){
			$c = new Conexion();
			$cone = $c->conectar();
			$c = "select * from usuarios as u inner join tipousuarios as tu on u.tipousuarios_idTipoUsuarios = tu.idTipoUsuarios";
			$rs = mysqli_query($cone,$c);
			$data = json_encode(mysqli_fetch_all($rs, MYSQLI_ASSOC));
			if($data){
				return '{"data":' . $data . '}';
			} else {
				echo "<script> alert('error')</script>";
			}
		}

		function modificar(){
			$c = new Conexion();
			$cone = $c->conectar();
			$insertar = "update usuarios set nombre='$this->nombre', apellido='$this->apellidos', nombreUsuario='$this->nick', email='$this->email', fechaDeNacimiento='$this->nacimiento', telefono='$this->telefono', direccion='$this->direccion', contraseña='$this->contrasena', tipoUsuarios_idTipoUsuarios='$this->tipoUsuario' where idUsuarios = $this->id";
			$query = mysqli_query($cone,$insertar);
			if(!$query){
				echo mysqli_error($cone);
				return;
		   	}
			echo "<script> alert('Usuario modificado correctamente')</script>";
		}

		function eliminar(){
			$c = new Conexion();
			$cone = $c->conectar();
			$c= "delete from usuarios where idUsuarios='$this->id'";
			$query = mysqli_query($cone,$c);
			echo "<script> alert('El usuario fue eliminado correctamente');</script>";
		}
	}
?>