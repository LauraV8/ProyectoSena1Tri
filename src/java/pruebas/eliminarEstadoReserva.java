
package pruebas;

import controlador.estadoReservasDAO;
import java.util.ArrayList;
import modelo.estadoreservas;

public class eliminarEstadoReserva {

    public static void main(String[] args) {
        estadoReservasDAO estadoreservasDao = new estadoReservasDAO();
        estadoreservas estadoreserva = estadoreservasDao.consultarEstadoReserva(1);
        
        if (estadoreserva != null) {
            System.out.println("nombreEstado : " + estadoreserva.getNombreEstado());
        } else {
            System.out.println("El estado de reserva no existe");
        }
        
        ArrayList<estadoreservas> listadoEstadoReservas = estadoreservasDao.ConsultarListadoEstadoReservas("");

        for (estadoreservas E : listadoEstadoReservas) {
            System.out.println(" Id. " + E.getIdEstadoReservas()+ "Nombre Estado: " + E.getNombreEstado());
        }

        System.out.println("Se eliminó");

        estadoreservasDao.eliminarEstadoReserva(listadoEstadoReservas.get(0));
        listadoEstadoReservas = estadoreservasDao.ConsultarListadoEstadoReservas("");

        for (estadoreservas E : listadoEstadoReservas) {
            System.out.println(" Id. " + E.getIdEstadoReservas()+ "Nombre Estado: " + E.getNombreEstado());
        }
    }

}
