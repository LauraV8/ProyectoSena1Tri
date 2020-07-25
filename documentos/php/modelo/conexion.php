<?php
	class Conexion{
		private $servidor = "localhost";
		private $usuario ="root";
		private $password = "";
		private $db = "mydb";

		public function conectar(){

			$con = mysqli_connect($this->servidor, $this->usuario, $this->password, $this->db)or die ("Error al conectar con el servidor comuniquese con el administrador"); 

			return $con;
		} 
	}

?>