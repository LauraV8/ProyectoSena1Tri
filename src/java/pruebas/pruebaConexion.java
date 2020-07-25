package pruebas;

import controlador.Conexion;
public class pruebaConexion {
    
    public static void main(String[] args) {
        Conexion con=new Conexion();
        con.getConn();
        System.out.println("conexión realizada correctamente");
    } 
}
