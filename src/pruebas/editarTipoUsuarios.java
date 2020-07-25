package pruebas;

import controlador.TipoUsuariosDAO;
import java.util.Scanner;
import modelo.tipousuarios;


public class editarTipoUsuarios {

    public static void main(String[] args) {

        TipoUsuariosDAO TipoUsuariosDAO = new TipoUsuariosDAO();
        tipousuarios mitipousuario = new tipousuarios();
        Scanner Leer = new Scanner(System.in);
              
        String tipoUsuario = "";
        int idTipoUsuarios;
        
        System.out.println("ingrese el id del tipo de usuario");
        idTipoUsuarios =Integer.parseInt(Leer.nextLine());
        mitipousuario.setIdTipoUsuarios(idTipoUsuarios);
        
        System.out.println("Por favor ingrese el nuevo tipo de usuario");
        tipoUsuario =Leer.nextLine();
        mitipousuario.setTipoUsuario(tipoUsuario);
        
        String respuesta = TipoUsuariosDAO.actualizarTipoUsuarios(mitipousuario);
        
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada de tipo de usuarios");
        } else {
            System.out.println("Error en la actualizacion" + respuesta);
        }
    }
}
