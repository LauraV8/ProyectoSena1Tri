package pruebas;
import controlador.ciudadesDAO;
import modelo.ciudades;

public class consultarCiudades {
    
    public static void main(String[] args) {
        
        ciudadesDAO ciudadesDAO = new ciudadesDAO();
        ciudades ciudades = ciudadesDAO.consultarciudades(1);
        
        if(ciudades != null){
            
            System.out.println("Encontrada la ciudad " + " - "  + ciudades.getIdCiudades() + " - " + ciudades.getNombreCiudad()+ " - " + ciudades.getNombreDepartamento()+ " - " + ciudades.getDireccion());
        
        } else {
            System.out.println("La ciudad no se encontró");
        }
    }   
}