
package pruebas;

import controlador.tipoDocumentosDAO;
import java.util.ArrayList;
import modelo.tipoDocumentos;

public class listarTipoDocumentos {

    public static void main(String[] args) {
        tipoDocumentosDAO arraytipodocumentosDao = new tipoDocumentosDAO();
        ArrayList<tipoDocumentos> tiposdocumento = new ArrayList<tipoDocumentos>();
        tiposdocumento = arraytipodocumentosDao.ConsultarListadoTipoDocumentos("");
        
        int size = tiposdocumento.size();
        System.out.println("<table border=\"1\"><tr><td>idTipoDocumentos</td><td>tipoDocumento</td>");
        
        for (tipoDocumentos i : tiposdocumento) {
            System.out.println("<tr>");
            System.out.println("<td>" + i.getIdTipoDocumentos() + "</td>");
            System.out.println("<td>" + i.gettipoDocumento() + "</td>");
            System.out.println("</tr>");
        }
        System.out.println("</table>");
    }
    
}
