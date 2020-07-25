
package pruebas;

import controlador.comentariosDAO;
import java.util.Scanner;
import modelo.comentarios;

public class editarComentario {

    public static void main(String[] args) {
        comentariosDAO comentariosDAO = new comentariosDAO();
        comentarios comentario = new comentarios();
        Scanner Leer = new Scanner(System.in);

        int idComentario;
        int calificacion;
        int idUsuario;
        String descripcion = "";
        
        System.out.println("ingrese el id del comentario");
        idComentario =Integer.parseInt(Leer.nextLine());
        comentario.setiIdComentarios(idComentario);

        System.out.println("ingrese la calificación");
        calificacion =Integer.parseInt(Leer.nextLine());
        comentario.setcCalificacion(calificacion);
        
        System.out.println("ingrese el id del usuario");
        idUsuario =Integer.parseInt(Leer.nextLine());
        comentario.setUsuarios_idUsuarios(idUsuario);

        System.out.println("Por favor ingrese la nueva descripción");
        descripcion = Leer.nextLine();
        comentario.setDescripcion(descripcion);
        
        String respuesta = comentariosDAO.actualizarComentarios(comentario);
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
