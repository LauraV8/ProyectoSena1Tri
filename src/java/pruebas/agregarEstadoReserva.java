
package pruebas;

import controlador.estadoReservasDAO;
import modelo.estadoreservas;

public class agregarEstadoReserva {

    public static void main(String[] args) {
        estadoreservas estadoreserva = new estadoreservas();
        estadoReservasDAO estadoReservasDAO = new estadoReservasDAO();
        estadoreserva.setNombreEstado("Pendiente");
        
        String respuesta = estadoReservasDAO.adicionarEstadoReserva(estadoreserva);
        
        if (respuesta.length() == 0) {
            System.out.println("Estado reserva agregado!");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
