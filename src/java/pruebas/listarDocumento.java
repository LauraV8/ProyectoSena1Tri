package pruebas;

import controlador.documentoDAO;
import modelo.documentos;
import java.util.ArrayList;


public class listarDocumento {

    public static void main(String[] args) {
        
        documentoDAO listarDocumento = new documentoDAO();
        
        ArrayList<documentos> listarDocumentos = new ArrayList <documentos>();
        
        ArrayList<documentos> documento = listarDocumento.listarDocumento("");
        
        int size = documento.size();
        
        System.out.print("<table border=\"1\"><tr><td>IdDocumento</td><td>TipoDeDocumento</td><td>numeroDeDcocumento</td></tr></table>");
           
        for (documentos D : documento){
            
            System.out.println("<tr>");
            
            System.out.println("<td>"+ D.getIdDocumentos()+"</td>");

            System.out.println("<td>"+ D.getNumeroDocumento()+"</td>");
            
            System.out.println("<td>"+ D.getTipoDocumentos_idTipoDocumentos()+"</td>");

            System.out.println("</tr>");
        }
        System.out.println("</table>");
       
    }
    
}
