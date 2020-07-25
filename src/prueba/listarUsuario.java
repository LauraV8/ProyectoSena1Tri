package pruebas;

import controlador.usuarioDAO;
import modelo.usuarios;
import java.util.ArrayList;

public class listarUsuario {
    
    public static void main(String[] args) {
        usuarioDAO miUsuarioDao = new usuarioDAO();
        ArrayList<usuarios> usuarios = new ArrayList<usuarios>();
        usuarios = miUsuarioDao.ListarUsuarios("");
         
        int size = usuarios.size();
        System.out.println("<table border=\"1\"><tr><td>Nombre</td><td>Apellido</td><td>NombreUsuario</td><td>Email</td><td>FechaDeNacimiento</td><td>Telefono</td><td>Direccion</td><td>Contraseña</td><td>Tipousuarios_idTipoUsuarios</td><td>IdUsuarios</td>");

        for (usuarios D : usuarios){
         System.out.println ("<tr>");
         System.out.println (("<td>") + D.getNombre()+ "<\td>");
         System.out.println (("<td>") + D.getApellido()+ "<\td>");
         System.out.println (("<td>") + D.getNombreUsuario()+ "<\td>");
         System.out.println (("<td>") + D.getEmail()+ "<\td>");
         System.out.println (("<td>") + D.getFechaDeNacimiento()+ "<\td>");
         System.out.println (("<td>") + D.getTelefono()+ "<\td>");
         System.out.println (("<td>") + D.getDireccion()+ "<\td>");
         System.out.println (("<td>") + D.getContraseña()+ "<\td>");
         System.out.println (("<td>") + D.getTipousuarios_idTipoUsuarios()+ "<\td>");
         System.out.println (("<td>") + D.getIdUsuarios()+ "<\td>");
         System.out.println ("<\tr>");
                
        }
     System.out.println("<\table>");
    }   
}
