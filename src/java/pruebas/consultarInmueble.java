package pruebas;

import modelo.inmuebles;
import controlador.inmuebleDAO;

public class consultarInmueble {

      public static void main(String[] args) {
             
        inmuebleDAO inmueblesDAO = new inmuebleDAO();
        inmuebles inmuebles = inmueblesDAO.consultarInmuebles(3);
        
        if(inmuebles != null){
            System.out.println("Encontrado el Id del inmueble: " + inmuebles.getIdInmuebles());
            System.out.println("Encontrado el nombre del inmueble: " + inmuebles.getNombre());
            System.out.println("Encontrado la Descripcion del inmueble: " + inmuebles.getDescripcion());
            System.out.println("Encontrado el precio del inmueble:  " + inmuebles.getPrecioAlquiler());
            System.out.println("Encontrado el tipo de inmueble: " + inmuebles.getTipoinmuebles_idTipoInmuebles());
            System.out.println("Encontrado la ciudad que pertenese el inmueble: " + inmuebles.getCiudades_idCiudades());

        } else {
            System.out.println("El usuario no se encontró");
        }
    }   
 }
   

