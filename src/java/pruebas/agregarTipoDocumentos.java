
package pruebas;

import controlador.tipoDocumentosDAO;
import modelo.tipoDocumentos;

public class agregarTipoDocumentos {

    public static void main(String[] args) {
        tipoDocumentos tipodocumento = new tipoDocumentos();
        tipoDocumentosDAO tipoDocumentosDAO = new tipoDocumentosDAO();
        tipodocumento.setTipoDocumento("RUT");
        
        String respuesta = tipoDocumentosDAO.adicionarTipoDocumentos(tipodocumento);
        
        if (respuesta.length() == 0) {
            System.out.println("Tipo documento agregado!");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
