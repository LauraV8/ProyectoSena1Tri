package pruebas;

import modelo.usuarios;
import controlador.usuarioDAO;
import java.util.ArrayList;

public class eliminarUsuario {

    public static void main(String[] args) {
        usuarioDAO miusuarioDAO = new usuarioDAO();
        usuarios usuarios = miusuarioDAO.consultarUsuarios(1);

        if (usuarios != null) {

            System.out.println("ID : " + usuarios.getIdUsuarios() );
            
        } else {
            System.out.println("El Id del usuario no existe ");
        }

        ArrayList<usuarios> listaUsu = miusuarioDAO.ListarUsuarios ("");

       for (usuarios T : listaUsu) {
            
            System.out.println("IdUsuario: " + T.getIdUsuarios() + "Nombre " + T.getNombre()+ "Apellido " + T.getApellido()+ "NombreUsuario " + T.getNombreUsuario()+ "Email " + T.getEmail()+ "Fechanaci " + T.getFechaDeNacimiento()+ "Telefono " + T.getTelefono()+ "Direccion " + T.getDireccion()+ "Contraseña " + T.getContraseña()+ "Tipousuario " + T.getTipousuarios_idTipoUsuarios());
        }
        
        System.out.println("Se eliminó");
        
        miusuarioDAO.eliminarUsuario(listaUsu.get(2));  
        
         for (usuarios T : listaUsu) {
            System.out.println("IdUsuario: " + T.getIdUsuarios() + "Nombre " + T.getNombre()+ "Apellido " + T.getApellido()+ "NombreUsuario " + T.getNombreUsuario()+ "Email " + T.getEmail()+ "Fechanaci " + T.getFechaDeNacimiento()+ "Telefono " + T.getTelefono()+ "Direccion " + T.getDireccion()+ "Contraseña " + T.getContraseña()+ "Tipousuario " + T.getTipousuarios_idTipoUsuarios());
        }

    }

}
