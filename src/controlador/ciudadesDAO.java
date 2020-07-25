package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.ciudades;
import java.util.ArrayList;


public class ciudadesDAO {

    public ciudades consultarciudades(int idCiudades){
        ciudades  Ciudades = null;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idCiudades, nombreCiudad, nombreDepartamento, direccion from ciudades where idCiudades = " + idCiudades;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                Ciudades = new ciudades();
                Ciudades.setIdCiudades(rs.getInt(1));
                Ciudades.setNombreCiudad(rs.getString(2));
                Ciudades.setNombreDepartamento(rs.getString(3));
                Ciudades.setDireccion(rs.getString(4));
            }
            return Ciudades;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de ciudad"+ ex.getMessage());
            return Ciudades;
            
        }
    }
    

    public ArrayList<ciudades> listarciudades(String criterio){
        ArrayList<ciudades>  Ciudades = new ArrayList<ciudades>();
        ciudades ciudades;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "SELECT *" + "FROM ciudades where IdCiudades like '%"+ criterio +"%' ORDER BY IdCiudades";
            
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                ciudades = new ciudades();
                ciudades.setIdCiudades(rs.getInt(1));
                ciudades.setNombreCiudad(rs.getString(2));
                ciudades.setNombreDepartamento(rs.getString(3));
                ciudades.setDireccion(rs.getString(4));
                Ciudades.add(ciudades);
            }
            return Ciudades;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta listado de ciudades" + ex.getMessage());
            return Ciudades;
        }
    }
    
    
    public String adicionarCiudades(ciudades ciudad) {
        String respuesta;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();
        PreparedStatement sentencia;
        
        try {
            String Query = "INSERT INTO ciudades (nombreCiudad, nombreDepartamento, direccion )" + "VALUES (?,?,?)";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, ciudad.getNombreCiudad());
            sentencia.setString(2, ciudad.getNombreDepartamento());
            sentencia.setString(3, ciudad.getDireccion());
            sentencia.execute();
            
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en ciudades" + ex.getMessage());
        }
        return respuesta;
    }
    
    public String actualizarciudades(ciudades ciudad) {
        
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update ciudades set nombreCiudad=?, nombreDepartamento=?, direccion=? where idCiudades=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, ciudad.getNombreCiudad()); 
            sentencia.setString(2, ciudad.getNombreDepartamento()); 
            sentencia.setString(3, ciudad.getDireccion());
            sentencia.setInt(4, ciudad.getIdCiudades());
            sentencia.executeUpdate();
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en ciudades" + ex.getMessage());
        }
        return respuesta;
    }
    public String eliminarCiudades (ciudades ciudades) {
             
            String respuesta;
        
         Conexion conexion = new Conexion();
         Connection nuevaCon;
         nuevaCon = conexion.getConn();
        
         PreparedStatement sentencia;
         
        try {
            String Query = "DELETE FROM ciudades WHERE idCiudades=? AND nombreCiudad=? AND nombreDepartamento=? AND direccion=?;";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, ciudades.getIdCiudades());
            sentencia.setString(2, ciudades.getNombreCiudad()); 
            sentencia.setString(3, ciudades.getNombreDepartamento());
            sentencia.setString(4, ciudades.getDireccion()); 
            sentencia.execute();
            respuesta = "";
               
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en eliminando la ciudad" + ex.getMessage());
        }
        return respuesta;

    }
}

