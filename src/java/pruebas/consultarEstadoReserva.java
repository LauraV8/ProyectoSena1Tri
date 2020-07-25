
package pruebas;

import controlador.estadoReservasDAO;
import modelo.estadoreservas;

public class consultarEstadoReserva {
    public static void main(String[] args) {
        estadoReservasDAO estadoReservasDao = new estadoReservasDAO();
        estadoreservas estadoreserva = estadoReservasDao.consultarEstadoReserva(1);
        
        if(estadoreserva != null){
            System.out.println("Encontrado el estado de reserva " + estadoreserva.getIdEstadoReservas() + " - " + estadoreserva.getNombreEstado());
        } else {
            System.out.println("El estado de reserva no se encontró");
        }
    }   
}
