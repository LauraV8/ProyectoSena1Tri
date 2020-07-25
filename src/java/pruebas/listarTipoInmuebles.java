package pruebas;

import modelo.tipoinmuebles;
import controlador.tipoInmueblesDAO;
import java.util.ArrayList;

public class listarTipoInmuebles {

    public static void main(String[] args) {
    
        tipoInmueblesDAO listarInmuebles = new tipoInmueblesDAO();
        
        ArrayList<tipoinmuebles> Inmueble = new ArrayList <tipoinmuebles>();
        
        ArrayList<tipoinmuebles> inmueble = listarInmuebles.ListarInmuebles("");
        
        int size = inmueble.size();
        
        System.out.print("<table border=\"1\"><tr><td>IdDocumento</td><td>TipoDeDocumento</td><td>numeroDeDcocumento</td></tr></table>");
           
        for (tipoinmuebles D : inmueble){
            
            System.out.println("<tr>");
            
            System.out.println("<td>"+ D.getIdTipoInmuebles()+"</td>");

            System.out.println("<td>"+ D.getTipoInmueble()+"</td>");
            
            System.out.println("</tr>");
        }
        System.out.println("</table>");
       
    }
 }
    