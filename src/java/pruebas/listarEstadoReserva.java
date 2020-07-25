
package pruebas;

import controlador.estadoReservasDAO;
import java.util.ArrayList;
import modelo.estadoreservas;

public class listarEstadoReserva {

    public static void main(String[] args) {
        estadoReservasDAO estadoReservasDao = new estadoReservasDAO();
        ArrayList<estadoreservas> estadoreservas = new ArrayList<estadoreservas>();
        estadoreservas = estadoReservasDao.ConsultarListadoEstadoReservas("");
        
        int size = estadoreservas.size();
        System.out.println("<table border=\"1\"><tr><td>idEstadoReservas</td><td>nombreEstado</td>");
        
        for (estadoreservas E : estadoreservas) {
            System.out.println("<tr>");
            System.out.println("<td>" + E.getIdEstadoReservas() + "</td>");
            System.out.println("<td>" + E.getNombreEstado() + "</td>");
            System.out.println("</tr>");
        }
        System.out.println("</table>");
    }
    
}
