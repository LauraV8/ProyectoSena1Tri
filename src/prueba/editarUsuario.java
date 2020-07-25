package pruebas;

import controlador.usuarioDAO;
import java.util.Scanner;
import modelo.usuarios;

public class editarUsuario {

    public static void main(String[] args) {

        usuarioDAO usuarioDAO = new usuarioDAO();
        usuarios usuario = new usuarios();
        Scanner Leer = new Scanner(System.in);

        String nombre = "";
        String apellido = "";
        String nombreUsuario = "";
        String email = "";
        String fechaDeNacimiento = "";
        String telefono = "";
        String contraseña = "";
        String direccion = "";
        int tipoUsuarios;
        int idusuario;
        
        System.out.println("ingrese el id del usuario");
        idusuario =Integer.parseInt(Leer.nextLine());
        usuario.setIdUsuarios(idusuario);


        System.out.println("Por favor ingrese el nuevo nombre");
        nombre = Leer.nextLine();
        usuario.setNombre(nombre);

        System.out.println("Por favor ingrese el nuevo apellido");
        apellido = Leer.nextLine();
        usuario.setApellido(apellido);

        System.out.println("Por favor ingrese el nuevo nombre de usuario");
        nombreUsuario = Leer.nextLine();
        usuario.setNombreUsuario(nombreUsuario);

        System.out.println("Por favor ingrese el nuevo email");
        email = Leer.nextLine();
        usuario.setEmail(email);
        
        System.out.println("Por favor ingrese la nueva contraseña");
        contraseña = Leer.nextLine();
        usuario.setContraseña(contraseña);

        System.out.println("Por favor ingrese la nueva fecha de nacimiento");
        fechaDeNacimiento = Leer.nextLine();
        usuario.setFechaDeNacimiento(fechaDeNacimiento);

        System.out.println("Por favor ingrese el nuevo teléfono");
        telefono = Leer.nextLine();
        usuario.setTelefono(telefono);

        System.out.println("Por favor ingrese la nueva dirección");
        direccion = Leer.nextLine();
        usuario.setDireccion(direccion);
        
        System.out.println("Por favor ingrese el nuevo tipo de usuario");
        tipoUsuarios =Integer.parseInt(Leer.nextLine());
        usuario.setTipousuarios_idTipoUsuarios(tipoUsuarios);
        
        String respuesta = usuarioDAO.actualizarUsuarios(usuario);
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
}
