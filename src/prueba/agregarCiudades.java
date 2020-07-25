package pruebas;

import controlador.ciudadesDAO;
import java.util.Scanner;
import modelo.ciudades;

public class agregarCiudades {
    
    public static void main(String[] args) {
        
        ciudades miciudad = new ciudades();
        ciudadesDAO ciudadesDAO = new ciudadesDAO();
        Scanner Leer = new Scanner(System.in);
        
        String nombreCiudad;
        String nombreDepartamento;
        String direccion;
        
        System.out.println("Por favor ingrese el nombre de la ciudad");
        nombreCiudad = Leer.nextLine();
        miciudad.setNombreCiudad(nombreCiudad);

        System.out.println("Por favor ingrese el nombre del departamento");
        nombreDepartamento = Leer.nextLine();
        miciudad.setNombreDepartamento(nombreDepartamento);

        System.out.println("Por favor ingrese la direccion");
        direccion = Leer.nextLine();
        miciudad.setDireccion(direccion);
        
        String respuesta = ciudadesDAO.adicionarCiudades(miciudad);
                

        if (respuesta.length() == 0) {
            
            System.out.println("Ciudad creada con exito!");
            
        } else {
            
            System.out.println("Error en creacion de la ciudad" + respuesta);
        }
    }
}