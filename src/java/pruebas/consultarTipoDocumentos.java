
package pruebas;

import controlador.tipoDocumentosDAO;
import modelo.tipoDocumentos;

public class consultarTipoDocumentos {
    public static void main(String[] args) {
        tipoDocumentosDAO tipoDocumentosDao = new tipoDocumentosDAO();
        tipoDocumentos tipoDeDocumento = tipoDocumentosDao.consultarTipoDocumentos(1);
        
        if(tipoDeDocumento != null){
            System.out.println("Encontrado el documento " + tipoDeDocumento.getIdTipoDocumentos() + " - " + tipoDeDocumento.gettipoDocumento());
        } else {
            System.out.println("El tipo de documento no se encontró");
        }
    }   
}
