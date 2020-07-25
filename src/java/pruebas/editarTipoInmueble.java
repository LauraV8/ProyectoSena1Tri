package pruebas;

import controlador.tipoInmueblesDAO;
import java.util.Scanner;
import modelo.tipoinmuebles;

public class editarTipoInmueble {

        public static void main(String[] args) {

        tipoinmuebles tipoinmueble = new tipoinmuebles();
        tipoInmueblesDAO tipoinmuebleDAO = new tipoInmueblesDAO();;
        Scanner Leer = new Scanner(System.in);

        String tipoInmueble = "";
        int IdtipoInmueble;

        
        System.out.println("ingrese el id del tipo de inmueble");
        IdtipoInmueble =Integer.parseInt(Leer.nextLine());
        tipoinmueble.setIdTipoInmuebles(IdtipoInmueble);


        System.out.println("Por favor ingrese el nombre");
        tipoInmueble = Leer.nextLine();
        tipoinmueble.setTipoInmueble(tipoInmueble);
        String respuesta = tipoinmuebleDAO.actualizartipoInmueble(tipoinmueble);
        
        if (respuesta.length() == 0) {
            
            System.out.println("Información Actualizada");
            
        } else {
            
            System.out.println("Error" + respuesta);
        }
     }
}   

