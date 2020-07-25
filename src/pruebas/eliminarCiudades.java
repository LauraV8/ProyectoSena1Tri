package pruebas;
        

import modelo.ciudades;
import controlador.ciudadesDAO;
import java.util.ArrayList;

public class eliminarCiudades {

    public static void main(String[] args) {
        ciudadesDAO miciudadDAO = new ciudadesDAO();
        ciudades ciudades = miciudadDAO.consultarciudades(1);

        if (ciudades != null) {

            System.out.println("ID : " + ciudades.getIdCiudades() );
            
        } else {
            System.out.println("El Id de la ciudad no existe ");
        }

        ArrayList<ciudades> listaciudad = miciudadDAO.listarciudades("");

       for (ciudades T : listaciudad) {
            
                System.out.println("IdCiudades: " + T.getIdCiudades() + "NombreCiudad " + T.getNombreCiudad()+ "NombreDepartamento " + T.getNombreDepartamento()+ "Direccion " + T.getDireccion());
        }
        
        System.out.println("SE ELIMINÓ");
        
        miciudadDAO.eliminarCiudades(listaciudad.get(1));  
        
         for (ciudades T : listaciudad) {
            System.out.println("IdCiudades: " + T.getIdCiudades() + "NombreCiudad " + T.getNombreCiudad()+ "NombreDepartamento " + T.getNombreDepartamento()+ "Direccion " + T.getDireccion());
        }

    }

}