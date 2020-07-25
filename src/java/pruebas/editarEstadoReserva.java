
package pruebas;

import controlador.estadoReservasDAO;
import java.util.Scanner;
import modelo.estadoreservas;

public class editarEstadoReserva {

    public static void main(String[] args) {
        estadoReservasDAO estadoReservasDAO = new estadoReservasDAO();
        estadoreservas estadoreserva = new estadoreservas();
        Scanner Leer = new Scanner(System.in);

        int idEstadoReservas;
        String nombreEstado = "";
        
        System.out.println("ingrese el id del estado de la reserva");
        idEstadoReservas =Integer.parseInt(Leer.nextLine());
        estadoreserva.setIdEstadoReservas(idEstadoReservas);

        System.out.println("ingrese el nuevo nombre de estado de reserva");
        nombreEstado = Leer.nextLine();
        estadoreserva.setNombreEstado(nombreEstado);
        
        String respuesta = estadoReservasDAO.actualizarEstadoReserva(estadoreserva);
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
