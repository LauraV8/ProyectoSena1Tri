
package pruebas;

import controlador.comentariosDAO;
import modelo.comentarios;

public class consultarComentario {
    
    public static void main(String[] args) {
        comentariosDAO comentariosDao = new comentariosDAO();
        comentarios comentario = comentariosDao.consultarComentario(4);
        
        if(comentario != null){
            System.out.println("Encontrado el comentario " + comentario.getIdComentarios() + "  " +  comentario.getCalificacion()+ "  " + comentario.getDescripcion()+ "  " +  comentario.getUsuarios_idUsuarios());
        } else {
            System.out.println("El comentario no se encontró");
        }
    }   
}
