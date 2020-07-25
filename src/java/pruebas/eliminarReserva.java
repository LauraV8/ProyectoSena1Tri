
package pruebas;

import controlador.reservasDAO;
import java.util.ArrayList;
import modelo.reservas;

public class eliminarReserva {

    public static void main(String[] args) {
        reservasDAO reservaDao = new reservasDAO();
        reservas reserva = reservaDao.consultarReserva(1);
        
        if (reserva != null) {
            System.out.println("idReserva : " + reserva.getIdReservas());
        } else {
            System.out.println("La reserva no existe");
        }
        
        ArrayList<reservas> listadosreservas = reservaDao.ConsultarListadoReservas("");

        for (reservas R : listadosreservas) {
            System.out.println("Id. " + R.getIdReservas() + "Estancia: " + R.getEstancia() + "Cantidad de personas: " + R.getCantidadDePersonas() + "Ingreso: " + R.getIngreso() + "Salida: " + R.getSalida() + "Inmuebles_idInmuebles: " + R.getInmuebles_idInmuebles() + "Usuarios_idUsuarios: " + R.getUsuarios_idUsuarios() + "Estadoreservas_idEstadoReservas: " + R.getEstadoreservas_idEstadoReservas());
        }

        System.out.println("Se eliminó");

        reservaDao.eliminarReserva(listadosreservas.get(0));
        listadosreservas = reservaDao.ConsultarListadoReservas("");

        for (reservas R : listadosreservas) {
            System.out.println("Id. " + R.getIdReservas() + "Estancia: " + R.getEstancia() + "Cantidad de personas: " + R.getCantidadDePersonas() + "Ingreso: " + R.getIngreso() + "Salida: " + R.getSalida() + "Inmuebles_idInmuebles: " + R.getInmuebles_idInmuebles() + "Usuarios_idUsuarios: " + R.getUsuarios_idUsuarios() + "Estadoreservas_idEstadoReservas: " + R.getEstadoreservas_idEstadoReservas());
        }
    }

}