package pruebas;

import controlador.documentoDAO;
import modelo.documentos;

public class consultarDocumento {
    
    public static void main(String[] args) {
        
        documentoDAO documentoDAO = new documentoDAO();
        documentos documento = documentoDAO.consultarDocumento(3);
        
        if(documento != null){
            
            System.out.println("Encontrado el documento " + documento.getIdDocumentos()+ " - " + documento.getIdDocumentos());
        
        } else {
            
            System.out.println("documento no encontrado");
            
        }
    }   
}