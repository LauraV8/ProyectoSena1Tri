
package pruebas;

import controlador.reservasDAO;
import java.util.Scanner;
import modelo.reservas;

public class editarReserva {

    public static void main(String[] args) {
        
        reservasDAO reservaDAO = new reservasDAO();
        reservas reserva = new reservas();
        Scanner Leer = new Scanner(System.in);
        
        int idReserva;
        String estancia = "";
        int cantidadDePersonas;
        String ingreso = "";
        String salida = "";
        int idInmuebles;
        int idUsuarios;
        int idEstadoReservas;
        
        System.out.println("ingrese el id de la reserva");
        idReserva =Integer.parseInt(Leer.nextLine());
        reserva.setIdReservas(idReserva);

        System.out.println("Por favor ingrese la nueva estancia");
        estancia = Leer.nextLine();
        reserva.setEstancia(estancia);

        System.out.println("Por favor ingrese la nueva cantidad de personas");
        cantidadDePersonas = Integer.parseInt(Leer.nextLine());
        reserva.setCantidadDePersonas(cantidadDePersonas);

        System.out.println("Por favor ingrese la nueva fecha de ingreso");
        ingreso = Leer.nextLine();
        reserva.setIngreso(ingreso);

        System.out.println("Por favor ingrese la nueva fecha de salida");
        salida = Leer.nextLine();
        reserva.setSalida(salida);
        
        System.out.println("Por favor ingrese el inmueble");
        idInmuebles = Integer.parseInt(Leer.nextLine());
        reserva.setInmuebles_idInmuebles(idInmuebles);

        System.out.println("Por favor ingrese el usuario");
        idUsuarios = Integer.parseInt(Leer.nextLine());
        reserva.setUsuarios_idUsuarios(idUsuarios);

        System.out.println("Por favor ingrese el estado de la reserva");
        idEstadoReservas = Integer.parseInt(Leer.nextLine());
        reserva.setEstadoreservas_idEstadoReservas(idEstadoReservas);
        
        String respuesta = reservaDAO.actualizarReserva(reserva);
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
}
