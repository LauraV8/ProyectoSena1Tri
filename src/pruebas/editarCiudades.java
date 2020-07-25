package pruebas;

import controlador.ciudadesDAO;
import java.util.Scanner;
import modelo.ciudades;


public class  editarCiudades{

    public static void main(String[] args) {

        ciudadesDAO ciudadesDAO = new ciudadesDAO();
        ciudades miciudad = new ciudades();
        Scanner Leer = new Scanner(System.in);

        int idCiudades;
        String nombreCiudad = "";
        String nombreDepartamento = "";
        String direccion = "";
        
        System.out.println("Por favor ingrese el id de la ciudad");
        idCiudades = Integer.parseInt(Leer.nextLine());
        miciudad.setIdCiudades(idCiudades);
        
        System.out.println("Por favor ingrese el nuevo nombre de la ciudad");
        nombreCiudad = Leer.nextLine();
        miciudad.setNombreCiudad(nombreCiudad);

        System.out.println("Por favor ingrese el nuevo nombre del departamento");
        nombreDepartamento = Leer.nextLine();
        miciudad.setNombreDepartamento(nombreDepartamento);

        System.out.println("Por favor ingrese la nueva direccion");
        direccion = Leer.nextLine();
        miciudad.setDireccion(direccion);
        
        String respuesta = ciudadesDAO.actualizarciudades(miciudad);
        
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada de ciudades");
        } else {
            System.out.println("Error en la actualizacion de la ciudad" + respuesta);
        }
    }
}
