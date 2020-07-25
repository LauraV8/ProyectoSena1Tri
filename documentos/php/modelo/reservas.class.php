<?php 
	class Reservas{

		public $id;
		public $estancia;
        public $cantidadDePersonas;
        public $ingreso;
        public $salida;
		public $estadoReserva;
		public $idInmueble;
		public $idUsuario;

		function getEstados() {
			$c = new Conexion();
			$cone = $c->conectar();
			$sql = "select * from estadoreservas";
			$query = mysqli_query($cone,$sql);
			$data = json_encode(mysqli_fetch_all($query, MYSQLI_ASSOC));
			if($data){
				return '{"data":' . $data . '}';
			} else {
				echo "<script> alert('error')</script>";
			}
		}

		function getInmuebles() {
			$c = new Conexion();
			$cone = $c->conectar();
			$sql = "select * from inmuebles";
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
			$insertar = "insert into reservas values(null, '$this->estancia', $this->cantidadDePersonas, '$this->ingreso','$this->salida', $this->estadoReserva, $this->idInmueble, '3')";
			$query = mysqli_query($cone,$insertar);
			echo "<script> alert('Reserva creada correctamente')</script>";
		}
		
		function consultas(){
			$c = new Conexion();
			$cone = $c->conectar();
			$c = "select * from reservas as r inner join estadoreservas as er on r.estadoreservas_idEstadoReservas = er.idEstadoReservas  inner join usuarios as u on r.Usuarios_idUsuarios = u.idUsuarios inner join inmuebles as i on r.inmuebles_idInmuebles = i.idInmuebles";
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
			$insertar = "update reservas set estancia='$this->estancia', cantidadDePersonas='$this->cantidadDePersonas', ingreso='$this->ingreso', salida='$this->salida', estadoreservas_idEstadoReservas='$this->estadoReserva', inmuebles_idInmuebles='$this->idInmueble' where idReservas = $this->id";
			$query = mysqli_query($cone,$insertar);
			echo "<script> alert('Reserva modificada correctamente')</script>";
		}

		function eliminar(){
			$c = new Conexion();
			$cone = $c->conectar();
			$c= "delete from reservas where idReservas='$this->id'";
			$query = mysqli_query($cone,$c);
			echo "<script> alert('La reserva fue eliminada correctamente');</script>";
		}
	}
?>