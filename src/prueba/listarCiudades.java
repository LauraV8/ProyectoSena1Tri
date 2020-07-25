package pruebas;
import controlador.ciudadesDAO;
import modelo.ciudades;
import java.util.ArrayList;

public class listarCiudades {
    
    public static void main(String[] args) {
        ciudadesDAO ciudadesDAO = new ciudadesDAO();
        ArrayList<ciudades> ciudades = new ArrayList<ciudades>();
        ciudades = ciudadesDAO.listarciudades("");
         
        int size = ciudades.size();
        System.out.println("<table border=\"1\"><tr><td>IdCiudades</td><td>NombreCiudad</td><td>NombreDepartamento</td><td>Direccion</td>");

        for (ciudades D : ciudades){
         System.out.println ("<tr>");
         System.out.println (("<td>") + D.getIdCiudades()+ "<\td>");
         System.out.println (("<td>") + D.getNombreCiudad()+ "<\td>");
         System.out.println (("<td>") + D.getNombreDepartamento()+ "<\td>");
         System.out.println (("<td>") + D.getDireccion()+ "<\td>");
         System.out.println ("<\tr>");
                
        }
     System.out.println("<\table>");
    }   
}
