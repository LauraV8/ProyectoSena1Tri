package pruebas;

import controlador.documentoDAO;
import java.util.ArrayList;
import modelo.documentos;

public class eliminarDocumento {

    public static void main(String[] args) {
        
        documentoDAO documentoDao = new documentoDAO();
        documentos documento = documentoDao.consultarDocumento(1);
        
        if (documento != null) {
            
            System.out.println("id de  Documento : " + documento.getIdDocumentos());
            
        } else {
            
            System.out.println("El documento no existe");
        }
        
        ArrayList<documentos> listaDocumentos = documentoDao.listarDocumento("");

        for (documentos T : listaDocumentos) {
            System.out.println(" Id." + "Documento: " + T.getIdDocumentos());
        }

        System.out.println("Se eliminó");

        documentoDao.EliminarDocumentos(listaDocumentos.get(0));
        
        listaDocumentos = documentoDao.listarDocumento("");

        for (documentos T : listaDocumentos) {
            
            System.out.println("Id." + "Documento: " + T.getIdDocumentos());
            
        }
    }

}