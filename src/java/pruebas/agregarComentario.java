
package pruebas;

import controlador.comentariosDAO;
import modelo.comentarios;

public class agregarComentario {

    public static void main(String[] args) {
        comentarios comentario = new comentarios();
        comentariosDAO comentariosDAO = new comentariosDAO();
        comentario.setcCalificacion(5);
        comentario.setDescripcion("Excelente servicio");
        comentario.setUsuarios_idUsuarios(2);
        
        String respuesta = comentariosDAO.adicionarComentarios(comentario);
        
        if (respuesta.length() == 0) {
            System.out.println("Comentario agregado!");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
