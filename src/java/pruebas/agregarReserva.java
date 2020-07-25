
package pruebas;

import controlador.reservasDAO;
import modelo.reservas;


public class agregarReserva {

    public static void main(String[] args) {
        reservas reserva = new reservas();
        reservasDAO reservasDAO = new reservasDAO();
        reserva.setEstancia("5 dias");
        reserva.setCantidadDePersonas(3);
        reserva.setIngreso("aaaaa");
        reserva.setSalida("bbbbb");
        reserva.setInmuebles_idInmuebles(1);
        reserva.setUsuarios_idUsuarios(1);
        reserva.setEstadoreservas_idEstadoReservas(1);
        
        String respuesta = reservasDAO.adicionarReserva(reserva);
        
        if (respuesta.length() == 0) {
            System.out.println("Reserva agregada!");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
