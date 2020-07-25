<?php 
	class Inmuebles{

		public $id;
		public $nombre;
		public $precioAlquiler;
		public $descripcion;
		public $tipoInmueble;
		public $idCiudad;

		function getTiposInmueble() {
			$c = new Conexion();
			$cone = $c->conectar();
			$sql = "select * from tipoinmuebles";
			$query = mysqli_query($cone,$sql);
			$data = json_encode(mysqli_fetch_all($query, MYSQLI_ASSOC));
			if($data){
				return '{"data":' . $data . '}';
			} else {
				echo "<script> alert('error')</script>";
			}
		}

		function getCiudades() {
			$c = new Conexion();
			$cone = $c->conectar();
			$sql = "select * from ciudades";
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
			$insertar = "insert into inmuebles values(null, '$this->nombre', '$this->precioAlquiler', '$this->descripcion', '$this->tipoInmueble', 3, '$this->idCiudad')";
			$query = mysqli_query($cone,$insertar);
			echo "<script> alert('inmueble creado correctamente')</script>";
		}
		
		function consultas(){
			$c = new Conexion();
			$cone = $c->conectar();
			$c = "select * from inmuebles as i inner join tipoinmuebles as ti on i.tipoinmuebles_idTipoInmuebles = ti.idTipoInmuebles inner join ciudades as c on i.ciudades_idCiudades = c.idCiudades";
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
			$insertar = "update inmuebles set nombre='$this->nombre', precioAlquiler='$this->precioAlquiler', descripcion='$this->descripcion', tipoinmuebles_idTipoInmuebles='$this->tipoInmueble', ciudades_idCiudades='$this->idCiudad' where idInmuebles = $this->id";
			$query = mysqli_query($cone,$insertar);
			echo "<script> alert('Inmueble modificado correctamente')</script>";
		}

		function eliminar(){
			$c = new Conexion();
			$cone = $c->conectar();
			$c= "delete from inmuebles where idInmuebles='$this->id'";
			$query = mysqli_query($cone,$c);
			echo "<script> alert('El inmueble fue eliminado correctamente');</script>";
		}
	}
?>