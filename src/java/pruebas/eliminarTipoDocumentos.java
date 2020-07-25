
package pruebas;

import controlador.tipoDocumentosDAO;
import java.util.ArrayList;
import modelo.tipoDocumentos;

public class eliminarTipoDocumentos {

    public static void main(String[] args) {
        tipoDocumentosDAO tipodocumentoDao = new tipoDocumentosDAO();
        tipoDocumentos tipodocumento = tipodocumentoDao.consultarTipoDocumentos(1);
        
        if (tipodocumento != null) {
            System.out.println("TipoDocumento : " + tipodocumento.gettipoDocumento());
        } else {
            System.out.println("El tipo de documento no existe");
        }
        
        ArrayList<tipoDocumentos> listadostipodocumentos = tipodocumentoDao.ConsultarListadoTipoDocumentos("");

        for (tipoDocumentos T : listadostipodocumentos) {
            System.out.println(" Id. " + T.getIdTipoDocumentos() + "Tipo Documento: " + T.gettipoDocumento());
        }

        System.out.println("Se eliminó");

        tipodocumentoDao.EliminarTipoDocumentos(listadostipodocumentos.get(0));
        listadostipodocumentos = tipodocumentoDao.ConsultarListadoTipoDocumentos("");

        for (tipoDocumentos T : listadostipodocumentos) {
            System.out.println("Id. " + T.getIdTipoDocumentos() + "Tipo Documento: " + T.gettipoDocumento());
        }
    }

}
