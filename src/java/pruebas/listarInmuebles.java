package pruebas;

import modelo.inmuebles;
import controlador.inmuebleDAO;
import java.util.ArrayList;

public class listarInmuebles {

    public static void main(String[] args) {
    
         inmuebleDAO listarInmuebles = new inmuebleDAO();
        
        ArrayList<inmuebles> Inmueble = new ArrayList <inmuebles>();
        
        ArrayList<inmuebles> inmueble = listarInmuebles.ListarInmuebles("");
        
        int size = inmueble.size();
        
        System.out.print("<table border=\"1\"><tr><td>IdDocumento</td><td>TipoDeDocumento</td><td>numeroDeDcocumento</td></tr></table>");
           
        for (inmuebles D : inmueble){
            
            System.out.println("<tr>");
            
            System.out.println("<td>"+ D.getIdInmuebles()+"</td>");

            System.out.println("<td>"+ D.getNombre()+"</td>");
            
            System.out.println("<td>"+ D.getDescripcion()+"</td>");
            
            System.out.println("<td>"+ D.getCiudades_idCiudades()+"</td>");
            
            System.out.println("<td>"+ D.getTipoinmuebles_idTipoInmuebles()+"</td>");
             
            System.out.println("<td>"+ D.getUsuarios_idUsuarios()+"</td>");

            System.out.println("</tr>");
        }
        System.out.println("</table>");
       
    }
 }
    

