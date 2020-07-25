
package pruebas;

import controlador.comentariosDAO;
import java.util.ArrayList;
import modelo.comentarios;

public class eliminarComentario {

    public static void main(String[] args) {
        comentariosDAO comentarioDao = new comentariosDAO();
        comentarios comentario = comentarioDao.consultarComentario(1);
        
        if (comentario != null) {
            System.out.println("idComentario : " + comentario.getIdComentarios());
        } else {
            System.out.println("El comentario no existe");
        }
        
        ArrayList<comentarios> listadoscomentarios = comentarioDao.ConsultarListadoComentarios("");

        for (comentarios C : listadoscomentarios) {
            System.out.println("Id. " + C.getIdComentarios() + "Calificación: " + C.getCalificacion() + "Descripción: " + C.getDescripcion() + "Usuario: " + C.getUsuarios_idUsuarios());
        }

        System.out.println("Se eliminó");

        comentarioDao.eliminarComentario(listadoscomentarios.get(1));
        listadoscomentarios = comentarioDao.ConsultarListadoComentarios("");

        for (comentarios C : listadoscomentarios) {
            System.out.println("Id. " + C.getIdComentarios() + "Calificación: " + C.getCalificacion() + "Descripción: " + C.getDescripcion() + "Usuario: " + C.getUsuarios_idUsuarios());
        }
    }

}
