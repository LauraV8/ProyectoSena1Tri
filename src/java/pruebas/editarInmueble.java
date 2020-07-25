package pruebas;

import controlador.inmuebleDAO;
import java.util.Scanner;
import modelo.inmuebles;



public class editarInmueble {

    public static void main(String[] args) {

        inmuebles inmueble = new inmuebles();
        inmuebleDAO inmuebleDAO = new inmuebleDAO();;
        Scanner Leer = new Scanner(System.in);

        String nombre = "";
        int precioAlquiler;
        String descripcion = "";
        int tipoInmueble;
        int ciudades;
        int idUsuarios;
        int idinmueble;
        
        System.out.println("ingrese el id del inmueble");
        idinmueble =Integer.parseInt(Leer.nextLine());
        inmueble.setIdInmuebles(idinmueble);


        System.out.println("Por favor ingrese el nombre");
        nombre = Leer.nextLine();
        inmueble.setNombre(nombre);

        System.out.println("Por favor ingrese el precio del alquiler");
        precioAlquiler = Integer.parseInt(Leer.nextLine());
        inmueble.setPrecioAlquiler(precioAlquiler);
        
        System.out.println("Por favor ingrese el tipo de inmueble");
        tipoInmueble = Integer.parseInt(Leer.nextLine());
        inmueble.setTipoinmuebles_idTipoInmuebles(tipoInmueble);
        
        
        System.out.println("Por favor ingrese una descripcion");
        descripcion = Leer.nextLine();
        inmueble.setDescripcion(descripcion);
        
        System.out.println("Por favor ingrese Id de usuario");
        idUsuarios =Integer.parseInt(Leer.nextLine());
        inmueble.setUsuarios_idUsuarios(idUsuarios);
        
        System.out.println("Por favor ingrese el id de la ciudad");
        ciudades =Integer.parseInt(Leer.nextLine());
        inmueble.setCiudades_idCiudades(ciudades);
        
        
        String respuesta = inmuebleDAO.actualizarInmueble(inmueble);
        
        if (respuesta.length() == 0) {
            
            System.out.println("Información Actualizada");
            
        } else {
            
            System.out.println("Error" + respuesta);
        }
    }
}
