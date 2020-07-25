
package controlador;

import modelo.estadoreservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class estadoReservasDAO {
    
public String adicionarEstadoReserva(estadoreservas estadoreserva) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;
        
        try {
            String Query = "INSERT INTO estadoreservas (idEstadoReservas, nombreEstado)" + "VALUES (null, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, estadoreserva.getNombreEstado());
   
            sentencia.execute();
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en estadoReservasDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Editar EstadoReservas
    public String actualizarEstadoReserva(estadoreservas estadoreserva) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update estadoreservas set nombreEstado=? where idEstadoReservas=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, estadoreserva.getNombreEstado());
            sentencia.setInt(2, estadoreserva.getIdEstadoReservas());
            
            sentencia.executeUpdate();
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en estadoReservasDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Eliminar EstadoReservas
    public String eliminarEstadoReserva (estadoreservas estadoreserva) {     
         String respuesta;
         Conexion conexion = new Conexion();
         Connection nuevaCon;
         nuevaCon = conexion.getConn();
        
         PreparedStatement sentencia;
         
        try {
            String Query = "DELETE FROM estadoreservas WHERE idEstadoReservas=? AND nombreEstado=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, estadoreserva.getIdEstadoReservas());
            sentencia.setString(2, estadoreserva.getNombreEstado());
            
            sentencia.execute();
            respuesta = "";
               
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en eliminar el estado de la reserva" + ex.getMessage());
        }
        return respuesta;

    }
    //Consultar EstadoReservas
    public estadoreservas consultarEstadoReserva(int idEstadoReservas){
        estadoreservas  estadoreserva = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idEstadoReservas, nombreEstado = " + idEstadoReservas;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                estadoreserva = new estadoreservas();
                
                estadoreserva.setIdEstadoReservas(rs.getInt(1));
                estadoreserva.setNombreEstado(rs.getString(2));
                         
            }
            return estadoreserva;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de estado de reservas" + ex.getMessage());
            return estadoreserva;
            
        }
    }
    //Listar EstadoReservas
    public ArrayList<estadoreservas> ConsultarListadoEstadoReservas(String criterio){
        ArrayList<estadoreservas> listadoEstadoReservas = new ArrayList<estadoreservas>();
        estadoreservas estadoreserva;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String query = "SELECT *" + "FROM estadoreservas where nombreEstado like '%"+ criterio +"%' ORDER BY nombreEstado";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()) {
                
                estadoreserva = new estadoreservas();
                estadoreserva.setIdEstadoReservas(rs.getInt(1));
                estadoreserva.setNombreEstado(rs.getString(2));
                listadoEstadoReservas.add(estadoreserva);
            }
            return listadoEstadoReservas;
        } catch (Exception ex) {
            System.out.println("Error consulta listado estado de reservas: " + ex.getMessage());
            return listadoEstadoReservas;
        }
    }
}

