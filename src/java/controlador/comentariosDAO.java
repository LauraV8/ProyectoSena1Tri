package controlador;

import modelo.comentarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipoDocumentos;

public class comentariosDAO {

    public String adicionarComentarios(comentarios comentario) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO comentarios (idComentarios, calificacion, descripcion, usuarios_idUsuarios)" + "VALUES (null, ?, ?, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, comentario.getCalificacion());
            sentencia.setString(2, comentario.getDescripcion());
            sentencia.setInt(3, comentario.getUsuarios_idUsuarios());
            sentencia.execute();
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en comentariosDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Actualizar comentarios
    public String actualizarComentarios(comentarios comentario) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update comentarios set calificacion=?, descripcion=?, Usuarios_idUsuarios=? where idComentarios=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, comentario.getCalificacion());
            sentencia.setString(2, comentario.getDescripcion());
            sentencia.setInt(3, comentario.getUsuarios_idUsuarios());
            sentencia.setInt(4, comentario.getIdComentarios());
            sentencia.executeUpdate();
            
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en comentariosDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Eliminar comentarios
    public String eliminarComentario (comentarios comentario) {     
         String respuesta;
         Conexion conexion = new Conexion();
         Connection nuevaCon;
         nuevaCon = conexion.getConn();
        
         PreparedStatement sentencia;
         
        try {
            String Query = "DELETE FROM comentarios WHERE idComentarios=? AND calificacion=? AND descripcion=? AND usuarios_idUsuarios=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, comentario.getIdComentarios());
            sentencia.setInt(2, comentario.getCalificacion());
            sentencia.setString(3, comentario.getDescripcion()); 
            sentencia.setInt(4, comentario.getUsuarios_idUsuarios());  
            
            sentencia.execute();
            respuesta = "";
               
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en eliminar el comentario" + ex.getMessage());
        }
        return respuesta;

    }
    //Consultar comentarios
    public comentarios consultarComentario(int idComentarios){
        comentarios  comentario = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idComentarios, calificacion, descripcion, usuarios_idUsuarios from comentarios where  idComentarios = " + idComentarios;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                comentario = new comentarios();
                
                comentario.setiIdComentarios(rs.getInt(1));
                comentario.setcCalificacion(rs.getInt(2));
                comentario.setDescripcion(rs.getString(3));
                comentario.setUsuarios_idUsuarios(rs.getInt(4));
                         
            }
            return comentario;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de comentarios"+ ex.getMessage());
            return comentario;
            
        }
    }
        
    //Listar comentarios
    public ArrayList<comentarios> ConsultarListadoComentarios(String criterio){
        ArrayList<comentarios> listadoComentarios = new ArrayList<comentarios>();
        comentarios comentario;

        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String query = "SELECT *" + "FROM comentarios where descripcion like '%"+ criterio +"%' ORDER BY descripcion";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()) {
                comentario = new comentarios();
                comentario.setiIdComentarios(rs.getInt(1));
                comentario.setcCalificacion(rs.getInt(2));
                comentario.setDescripcion(rs.getString(3));
                comentario.setUsuarios_idUsuarios(rs.getInt(4));
                listadoComentarios.add(comentario);
            }
            return listadoComentarios;
        } catch (Exception ex) {
            System.out.println("Error consulta listado TipoDocumentos: " + ex.getMessage());
            return listadoComentarios;
        }
    }
}
