
package pruebas;
import controlador.usuarioDAO;
import java.util.Random;
import modelo.usuarios;
public class agregarUsuario {
    public static void main(String[] args) {
        usuarios usuario = new usuarios();
        usuarioDAO usuariosDAO = new usuarioDAO();
        Random random = new Random();
        usuario.setNombre("Carlos");
        usuario.setApellido("Martinez");
        usuario.setEmail("carlosma@hotmail.com");
        usuario.setNombreUsuario("carmar"+String.valueOf(random.nextInt()));
        usuario.setFechaDeNacimiento("24101986");
        usuario.setTelefono("4785962");
        usuario.setDireccion("calle670514");
        usuario.setContraseña("1254car");
        usuario.setTipousuarios_idTipoUsuarios(1);
        String respuesta = usuariosDAO.adicionarUsuario(usuario);
        if (respuesta.length() == 0) {
            System.out.println("Usuario creado!");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
}
