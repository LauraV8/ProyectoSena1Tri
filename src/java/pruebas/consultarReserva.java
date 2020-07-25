
package pruebas;

import controlador.reservasDAO;
import modelo.reservas;

public class consultarReserva {
    
    public static void main(String[] args) {
        reservasDAO reservasDao = new reservasDAO();
        reservas reserva = reservasDao.consultarReserva(3);
        
        if(reserva != null){
            System.out.println("Encontrada la reserva " + reserva.getIdReservas() + "  " +  reserva.getEstancia()+ "  " + reserva.getCantidadDePersonas()+ "  " +  reserva.getIngreso()+ "  " +  reserva.getSalida()+ "  " +  reserva.getInmuebles_idInmuebles()+ "  " +  reserva.getUsuarios_idUsuarios()+ "  " +  reserva.getEstadoreservas_idEstadoReservas());
        } else {
            System.out.println("La reserva no se encontró");
        }
    }   
}

