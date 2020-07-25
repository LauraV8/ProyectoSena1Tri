package pruebas;

import java.util.Scanner;
import modelo.documentos;
import controlador.documentoDAO;

public class editarDocumento {
    public static void main(String[] args) {
        
        
        documentos documento = new documentos();
        documentoDAO documentoDAO = new documentoDAO();;
        Scanner Leer = new Scanner(System.in);

        int tipoDocumento;
        String numeroDocumento="";
        int idDocumento;
        

        System.out.println("ingrese el id del documento");
        idDocumento =Integer.parseInt(Leer.nextLine());
        documento.setIdDocumentos(idDocumento);

        System.out.println("Por favor ingrese el numero de documento");
        numeroDocumento = Leer.nextLine();
        documento.setNumeroDocumento(numeroDocumento);
                       
        String respuesta = documentoDAO.actualizarDocumentos(documento);
        
        if (respuesta.length() == 0) {
            
            System.out.println("Información Actualizada");
            
        } else {
            
            System.out.println("Error" + respuesta);
        }
    }
}
