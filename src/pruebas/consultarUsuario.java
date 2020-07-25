package pruebas;

import controlador.usuarioDAO;
import modelo.usuarios;

public class consultarUsuario {
    
    public static void main(String[] args) {
        usuarioDAO UsuariosDao = new usuarioDAO();
        usuarios Usuarios = UsuariosDao.consultarUsuarios(6);
        
        if(Usuarios != null){
            System.out.println("Encontrado el usuario " + Usuarios.getIdUsuarios() + "  " + Usuarios.getNombre() + "  " + Usuarios.getApellido() + "  " + Usuarios.getNombreUsuario()+"  " +  Usuarios.getEmail()+ "  " + Usuarios.getFechaDeNacimiento()+ "  " + Usuarios.getTelefono()+"  " +  Usuarios.getDireccion()+ "  " + Usuarios.getContraseña()+"  " +  Usuarios.getTipousuarios_idTipoUsuarios());
        } else {
            System.out.println("El usuario no se encontró");
        }
    }   
}
