package controlador;

import modelo.usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class usuarioDAO {

    public String adicionarUsuario(usuarios usuario) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO usuarios (idUsuarios, nombre, apellido, nombreUsuario, email, fechaDeNacimiento, telefono, direccion, contraseña, tipousuarios_idTipoUsuarios)" + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setString(3, usuario.getNombreUsuario());
            sentencia.setString(4, usuario.getEmail());
            sentencia.setString(5, usuario.getFechaDeNacimiento());
            sentencia.setString(6, usuario.getTelefono());
            sentencia.setString(7, usuario.getDireccion());
            sentencia.setString(8, usuario.getContraseña());
            sentencia.setInt(9, usuario.getTipousuarios_idTipoUsuarios());
            sentencia.execute();
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en UsuarioDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Actualizar usuarios
    public String actualizarUsuarios(usuarios usuario) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update usuarios set nombre=?, apellido=?, nombreUsuario=?, email=?, fechaDeNacimiento=?, telefono=?, direccion=?, contraseña=?, tipousuarios_idTipoUsuarios=? where idUsuarios=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setString(3, usuario.getNombreUsuario());
            sentencia.setString(4, usuario.getEmail());
            sentencia.setString(5, usuario.getFechaDeNacimiento());
            sentencia.setString(6, usuario.getTelefono());
            sentencia.setString(7, usuario.getDireccion());
            sentencia.setString(8, usuario.getContraseña());
            sentencia.setInt(9, usuario.getTipousuarios_idTipoUsuarios());
            sentencia.setInt(10, usuario.getIdUsuarios());
            sentencia.executeUpdate();
            respuesta = "";
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en usuarioDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Eliminar usuarios
    public String eliminarUsuario (usuarios usuarios) {
             
            String respuesta;
        
         Conexion conexion = new Conexion();
         Connection nuevaCon;
         nuevaCon = conexion.getConn();
        
         PreparedStatement sentencia;
         
        try {
            String Query = "DELETE FROM usuarios WHERE idUsuarios=? AND nombre=? AND apellido=? AND nombreUsuario=? AND email=? AND fechaDeNacimiento=? AND telefono=? AND direccion=? AND contraseña=? AND tipousuarios_idTipoUsuarios=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setInt(1, usuarios.getIdUsuarios());
            sentencia.setString(2, usuarios.getNombre());
            sentencia.setString(3, usuarios.getApellido()); 
            sentencia.setString(4, usuarios.getNombreUsuario()); 
            sentencia.setString(5, usuarios.getEmail()); 
            sentencia.setString(6, usuarios.getFechaDeNacimiento()); 
            sentencia.setString(7, usuarios.getTelefono()); 
            sentencia.setString(8, usuarios.getDireccion()); 
            sentencia.setString(9, usuarios.getContraseña());
            sentencia.setInt(10, usuarios.getTipousuarios_idTipoUsuarios()); 
            
            sentencia.execute();
            respuesta = "";
               
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en eliminar el usuario" + ex.getMessage());
        }
        return respuesta;

    }
    //Listar usuarios
    public ArrayList<usuarios> ListarUsuarios(String criterio){
        ArrayList<usuarios>  Usuario = new ArrayList<usuarios>();
        usuarios miusuario;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "SELECT *" +  "FROM  usuarios where  idUsuarios  like '%"+ criterio +"%' ORDER BY idUsuarios";
            
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                miusuario = new usuarios();
                miusuario.setIdUsuarios(rs.getInt(1));
                miusuario.setNombre(rs.getString(2));
                miusuario.setApellido(rs.getString(3));
                miusuario.setNombreUsuario(rs.getString(4));
                miusuario.setEmail(rs.getString(5));
                miusuario.setFechaDeNacimiento(rs.getString(6));
                miusuario.setTelefono(rs.getString(7));
                miusuario.setDireccion(rs.getString(8));
                miusuario.setContraseña(rs.getString(9));
                miusuario.setTipousuarios_idTipoUsuarios(rs.getInt(10));
                Usuario.add(miusuario);      
            }
            return Usuario;
        }
        catch (Exception ex) {
            System.out.println("Error en la consulta de listado de usuarios" + ex.getMessage());
            return Usuario;
        }
    }
    //Consultar usuarios
    public usuarios consultarUsuarios(int idUsuario){
        usuarios  Usuario = null;
        
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idUsuarios, nombre, apellido, nombreUsuario, email, fechaDeNacimiento, telefono, direccion, contraseña, tipousuarios_idTipoUsuarios from usuarios where  idUsuarios = " + idUsuario;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                Usuario = new usuarios();
                
                Usuario.setIdUsuarios(rs.getInt(1));
                Usuario.setNombre(rs.getString(2));
                Usuario.setApellido(rs.getString(3));
                Usuario.setNombreUsuario(rs.getString(4));
                Usuario.setEmail(rs.getString(5));
                Usuario.setFechaDeNacimiento(rs.getString(6));
                Usuario.setTelefono(rs.getString(7));
                Usuario.setDireccion(rs.getString(8));
                Usuario.setContraseña(rs.getString(9));
                Usuario.setTipousuarios_idTipoUsuarios(rs.getInt(10));
                         
            }
            return Usuario;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de usuarios"+ ex.getMessage());
            return Usuario;
            
        }
    }
}
