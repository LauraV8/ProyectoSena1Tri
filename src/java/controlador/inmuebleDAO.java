package controlador;

import modelo.inmuebles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class inmuebleDAO {
    
public String adicionarInmueble(inmuebles inmueble) {
    
        String esta;
        Conexion Conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = Conexion.getConn();
        PreparedStatement sentencia;
        
        try {
            String Query = "INSERT INTO inmuebles (idInmuebles, nombre, precioAlquiler, descripcion, tipoinmuebles_idTipoInmuebles, usuarios_idUsuarios, ciudades_idCiudades)" + "VALUES (null, ?, ?, ?, ?, ?, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, inmueble.getNombre());
            sentencia.setInt(2, inmueble.getPrecioAlquiler());
            sentencia.setString(3, inmueble.getDescripcion());
            sentencia.setInt(4, inmueble.getTipoinmuebles_idTipoInmuebles());
            sentencia.setInt(5, inmueble.getUsuarios_idUsuarios());
            sentencia.setInt(6, inmueble.getCiudades_idCiudades());;
            sentencia.execute();
            esta = "";
            
        } catch (Exception ex) {
            esta = ex.getMessage();
            System.err.println("Ocurrió un error en inmuebleDAO\n" + ex.getMessage());
        }
        return esta;
    }

    public String actualizarInmueble(inmuebles inmueble) {
        
        String esta;
        
        Conexion Conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = Conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update inmuebles set nombre=?, precioAlquiler=?, descripcion=?, tipoinmuebles_idTipoInmuebles=?, usuarios_idUsuarios=?, ciudades_idCiudades=? where idInmuebles=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, inmueble.getNombre());
            sentencia.setInt(2, inmueble.getPrecioAlquiler());
            sentencia.setString(3, inmueble.getDescripcion());
            sentencia.setInt(4, inmueble.getTipoinmuebles_idTipoInmuebles());
            sentencia.setInt(5, inmueble.getUsuarios_idUsuarios());
            sentencia.setInt(6, inmueble.getCiudades_idCiudades());;
            sentencia.setInt(7, inmueble.getIdInmuebles());
            sentencia.executeUpdate();
            esta = "";
            
        } catch (Exception ex) {
            esta = ex.getMessage();
            System.err.println("Ocurrio un error en inmuebles\n" + ex.getMessage());
        }
        return esta;
    }

    public String eliminarInmueblesinmueble(int id) {
        String sql = "delete from  inmuebles where idInmuebles=" + id;
               
        String esta;
        
        try {
            
            Conexion Conexion = new Conexion();
            Connection nuevaCon;
            nuevaCon = Conexion.getConn();
            PreparedStatement sentencia;
            sentencia =  nuevaCon.prepareStatement(sql);
            sentencia.executeUpdate();
            esta = "";
            
        } catch (Exception ex) {
            
            esta = ex.getMessage();
            System.err.println("Ocurrio un error en inmuebles\n" + ex.getMessage());
        }
        return esta;

    }
        public inmuebles consultarInmuebles(int idInmuebles){
        inmuebles  inmueble = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idinmuebles, nombre, precioAlquiler, descripcion, tipoinmuebles_idTipoInmuebles, usuarios_idUsuarios, ciudades_idCiudades from inmuebles where  idInmuebles = " + idInmuebles;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                inmueble = new inmuebles();
                
                inmueble.setIdInmuebles(rs.getInt(1));
                inmueble.setNombre(rs.getString(2));
                inmueble.setPrecioAlquiler(rs.getInt(3));
                inmueble.setDescripcion(rs.getString(4));
                inmueble.setTipoinmuebles_idTipoInmuebles(rs.getInt(5));
                inmueble.setUsuarios_idUsuarios(rs.getInt(6));
                inmueble.setCiudades_idCiudades(rs.getInt(7));
                         
            }
            return inmueble;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de inmueble"+ ex.getMessage());
            return inmueble;
            
        }
    }
        
    public ArrayList<inmuebles> ListarInmuebles(String criterio){
        ArrayList<inmuebles> listadoInmuebles = new ArrayList<inmuebles>();
        inmuebles inmueble;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String query = "SELECT *" + "FROM inmuebles where nombre like '%"+ criterio +"%' ORDER BY nombre";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()) {
                
                inmueble = new inmuebles();
                
                inmueble.setIdInmuebles(rs.getInt(1));
                inmueble.setNombre(rs.getString(2));
                inmueble.setPrecioAlquiler(rs.getInt(3));
                inmueble.setDescripcion(rs.getString(4));
                inmueble.setTipoinmuebles_idTipoInmuebles(rs.getInt(5));
                inmueble.setUsuarios_idUsuarios(rs.getInt(6));
                inmueble.setCiudades_idCiudades(rs.getInt(7));
                listadoInmuebles.add(inmueble);
                
            }
            return listadoInmuebles;
            
        } catch (Exception ex) {
            System.out.println("Error consulta listado reservas: " + ex.getMessage());
            return listadoInmuebles;
        }
    }
}

