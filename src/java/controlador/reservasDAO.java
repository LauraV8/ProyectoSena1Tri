
package controlador;

import modelo.reservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class reservasDAO {
    
public String adicionarReserva(reservas reserva) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;
        
        try {
            String Query = "INSERT INTO reservas (idReservas, estancia, cantidadDePersonas, ingreso, salida, inmuebles_idInmuebles, usuarios_idUsuarios, estadoreservas_idEstadoReservas)" + "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, reserva.getEstancia());
            sentencia.setInt(2, reserva.getCantidadDePersonas());
            sentencia.setString(3, reserva.getIngreso());
            sentencia.setString(4, reserva.getSalida());
            sentencia.setInt(5, reserva.getInmuebles_idInmuebles());
            sentencia.setInt(6, reserva.getUsuarios_idUsuarios());
            sentencia.setInt(7, reserva.getEstadoreservas_idEstadoReservas());
   
            sentencia.execute();
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en reservasDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Editar reservas
    public String actualizarReserva(reservas reserva) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update reservas set estancia=?, cantidadDePersonas=?, ingreso=?, salida=?, inmuebles_idInmuebles=?, usuarios_idUsuarios=?, estadoreservas_idEstadoReservas=? where idReservas=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, reserva.getEstancia());
            sentencia.setInt(2, reserva.getCantidadDePersonas());
            sentencia.setString(3, reserva.getIngreso());
            sentencia.setString(4, reserva.getSalida());
            sentencia.setInt(5, reserva.getInmuebles_idInmuebles());
            sentencia.setInt(6, reserva.getUsuarios_idUsuarios());
            sentencia.setInt(7, reserva.getEstadoreservas_idEstadoReservas());
            sentencia.setInt(8, reserva.getIdReservas());
            sentencia.executeUpdate();
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en reservasDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Eliminar reservas
    public String eliminarReserva (reservas reserva) {     
         String respuesta;
         Conexion conexion = new Conexion();
         Connection nuevaCon;
         nuevaCon = conexion.getConn();
        
         PreparedStatement sentencia;
         
        try {
            String Query = "DELETE FROM reservas WHERE idReservas=? AND estancia=? AND cantidadDePersonas=? AND ingreso=? AND salida=? AND inmuebles_idInmuebles=? AND usuarios_idUsuarios=? AND estadoreservas_idEstadoReservas=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, reserva.getIdReservas());
            sentencia.setString(2, reserva.getEstancia());
            sentencia.setInt(3, reserva.getCantidadDePersonas()); 
            sentencia.setString(4, reserva.getIngreso());
            sentencia.setString(5, reserva.getSalida());
            sentencia.setInt(6, reserva.getInmuebles_idInmuebles());
            sentencia.setInt(7, reserva.getUsuarios_idUsuarios()); 
            sentencia.setInt(8, reserva.getEstadoreservas_idEstadoReservas()); 
            
            sentencia.execute();
            respuesta = "";
               
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en eliminar la reserva" + ex.getMessage());
        }
        return respuesta;

    }
    //Consultar reservas
    public reservas consultarReserva(int idReservas){
        reservas  reserva = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idReservas, estancia, cantidadDePersonas, ingreso, salida, inmuebles_idInmuebles, usuarios_idUsuarios, estadoreservas_idEstadoReservas from reservas where  idReservas = " + idReservas;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                reserva = new reservas();
                
                reserva.setIdReservas(rs.getInt(1));
                reserva.setEstancia(rs.getString(2));
                reserva.setCantidadDePersonas(rs.getInt(3));
                reserva.setIngreso(rs.getString(4));
                reserva.setSalida(rs.getString(5));
                reserva.setInmuebles_idInmuebles(rs.getInt(6));
                reserva.setUsuarios_idUsuarios(rs.getInt(7));
                reserva.setEstadoreservas_idEstadoReservas(rs.getInt(8));
                         
            }
            return reserva;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de reservas"+ ex.getMessage());
            return reserva;
            
        }
    }
    //Listar reservas
    public ArrayList<reservas> ConsultarListadoReservas(String criterio){
        ArrayList<reservas> listadoReservas = new ArrayList<reservas>();
        reservas reserva;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String query = "SELECT *" + "FROM reservas where estancia like '%"+ criterio +"%' ORDER BY estancia";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()) {
                reserva = new reservas();
                reserva.setIdReservas(rs.getInt(1));
                reserva.setEstancia(rs.getString(2));
                reserva.setCantidadDePersonas(rs.getInt(3));
                reserva.setIngreso(rs.getString(4));
                reserva.setSalida(rs.getString(5));
                reserva.setInmuebles_idInmuebles(rs.getInt(6));
                reserva.setUsuarios_idUsuarios(rs.getInt(7));
                reserva.setEstadoreservas_idEstadoReservas(rs.getInt(8));
                listadoReservas.add(reserva);
            }
            return listadoReservas;
        } catch (Exception ex) {
            System.out.println("Error consulta listado reservas: " + ex.getMessage());
            return listadoReservas;
        }
    }
}
