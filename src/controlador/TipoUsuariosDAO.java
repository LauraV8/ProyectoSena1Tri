package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.tipousuarios;
import java.util.ArrayList;


public class TipoUsuariosDAO {

    public tipousuarios consultarTipoUsuarios(int idTipoUsuarios){
        
        tipousuarios  TipoUsuario = null;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = "Select "
                    + "idTipoUsuarios, tipoUsuario from tipousuarios where idTipoUsuarios = " + idTipoUsuarios;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                TipoUsuario = new tipousuarios();
                TipoUsuario.setIdTipoUsuarios(rs.getInt(1));
                TipoUsuario.setTipoUsuario(rs.getString(2));
            }
            return TipoUsuario;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de tipo de usuarios"+ ex.getMessage());
            return TipoUsuario;
            
        }
    }
    

    public ArrayList<tipousuarios> ConsultarListaTipoUsuarios(String criterio){
        
        ArrayList<tipousuarios>  ListaTipoUsuario = new ArrayList<tipousuarios>();
        
        tipousuarios tipousuarios;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "SELECT idTipoUsuarios, tipoUsuario " + " FROM tipousuarios where idTipoUsuarios like '%" + criterio + "%' ORDER BY idTipoUsuarios";
            
            ResultSet rs = sentencia.executeQuery(Query);
            
            while (rs.next()) {
                
                tipousuarios = new tipousuarios();
                tipousuarios.setIdTipoUsuarios(rs.getInt(1));
                tipousuarios.setTipoUsuario(rs.getString(2));
                ListaTipoUsuario.add(tipousuarios);
                
            }
            
            return ListaTipoUsuario;
        }
        catch (Exception ex) {
            
            System.out.println("Error en consulta listado tipo de usuarios" + ex.getMessage());
            return ListaTipoUsuario;
            
        }
    }
    
    
    public String adicionarTipoUsuarios(tipousuarios tipousuario) {
        String respuesta;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();
        PreparedStatement sentencia;
        
        try {
            String Query = "INSERT INTO tipousuarios (tipoUsuario)" + "VALUES (?);";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, tipousuario.getTipoUsuario());
            sentencia.execute();
            
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error agregando el tipo de usuario " + ex.getMessage());
        }
        return respuesta;
    }
    
    public String actualizarTipoUsuarios(tipousuarios tipousuario) {
        
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update tipousuarios set tipoUsuario=? where idTipoUsuarios=?";

            sentencia =  nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, tipousuario.getTipoUsuario());
            sentencia.setInt(2, tipousuario.getIdTipoUsuarios());
            sentencia.executeUpdate();
            
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error al editar el tipo de usuario\n" + ex.getMessage());
        }
        return respuesta;
    }
    
    public String eliminarTipoUsuarios (tipousuarios tipousuarios) {
             
            String respuesta;
        
         Conexion conexion = new Conexion();
         Connection nuevaCon;
         nuevaCon = conexion.getConn();
        
         PreparedStatement sentencia;
         
        try {
            String Query = "DELETE FROM tipousuarios WHERE idTipoUsuarios=? AND tipoUsuario=?;";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, tipousuarios.getIdTipoUsuarios());
            sentencia.setString(2, tipousuarios.getTipoUsuario()); 
            sentencia.execute();
            respuesta = "";
               
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en eliminando el tipo de usuario" + ex.getMessage());
        }
        return respuesta;

    }
}

