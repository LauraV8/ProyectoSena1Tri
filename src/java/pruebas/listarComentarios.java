
package pruebas;

import controlador.comentariosDAO;
import java.util.ArrayList;
import modelo.comentarios;

public class listarComentarios {

    public static void main(String[] args) {
        comentariosDAO arraycomentariosDao = new comentariosDAO();
        ArrayList<comentarios> comentarios = new ArrayList<comentarios>();
        comentarios = arraycomentariosDao.ConsultarListadoComentarios("");
        
        int size = comentarios.size();
        System.out.println("<table border=\"1\"><tr><td>idComentarios</td><td>calificacion</td><td>descripcion</td><td>usuarios_idUsuarios</td>");
        
        for (comentarios i : comentarios) {
            System.out.println("<tr>");
            System.out.println("<td>" + i.getIdComentarios()+ "</td>");
            System.out.println("<td>" + i.getCalificacion()+ "</td>");
            System.out.println("<td>" + i.getDescripcion()+ "</td>");
            System.out.println("<td>" + i.getUsuarios_idUsuarios()+ "</td>");
            System.out.println("</tr>");
        }
        System.out.println("</table>");
    }
    
}
