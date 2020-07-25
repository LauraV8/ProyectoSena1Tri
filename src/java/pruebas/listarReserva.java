
package pruebas;

import controlador.reservasDAO;
import java.util.ArrayList;
import modelo.reservas;

public class listarReserva {

    public static void main(String[] args) {
        reservasDAO reservasDao = new reservasDAO();
        ArrayList<reservas> reservas = new ArrayList<reservas>();
        reservas = reservasDao.ConsultarListadoReservas("");
        
        int size = reservas.size();
        System.out.println("<table border=\"1\"><tr><td>idReservas</td><td>estancia</td><td>cantidadDePersonas</td><td>ingreso</td><td>salida</td><td>inmuebles_idInmuebles</td><td>usuarios_idUsuarios</td><td>estadoreservas_idEstadoReservas</td>");
        
        for (reservas r : reservas) {
            System.out.println("<tr>");
            System.out.println("<td>" + r.getIdReservas()+ "</td>");
            System.out.println("<td>" + r.getEstancia()+ "</td>");
            System.out.println("<td>" + r.getCantidadDePersonas()+ "</td>");
            System.out.println("<td>" + r.getIngreso()+ "</td>");
            System.out.println("<td>" + r.getSalida()+ "</td>");
            System.out.println("<td>" + r.getInmuebles_idInmuebles()+ "</td>");
            System.out.println("<td>" + r.getUsuarios_idUsuarios()+ "</td>");
            System.out.println("<td>" + r.getEstadoreservas_idEstadoReservas()+ "</td>");
            System.out.println("</tr>");
        }
        System.out.println("</table>");
    }
    
}
