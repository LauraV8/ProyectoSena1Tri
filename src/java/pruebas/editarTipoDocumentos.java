
package pruebas;

import controlador.tipoDocumentosDAO;
import java.util.Scanner;
import modelo.tipoDocumentos;

public class editarTipoDocumentos {

    public static void main(String[] args) {
        tipoDocumentosDAO tipoDocumentosDAO = new tipoDocumentosDAO();
        tipoDocumentos tipodocumento = new tipoDocumentos();
        Scanner Leer = new Scanner(System.in);

        int idTipoDocumentos;
        String tipoDocumento = "";
        
        System.out.println("ingrese el id del tipo de documento");
        idTipoDocumentos =Integer.parseInt(Leer.nextLine());
        tipodocumento.setIdTipoDocumentos(idTipoDocumentos);

        System.out.println("ingrese el nuevo tipo de documento");
        tipoDocumento = Leer.nextLine();
        tipodocumento.setTipoDocumento(tipoDocumento);
        
        String respuesta = tipoDocumentosDAO.actualizarTipoDocumentos(tipodocumento);
        if (respuesta.length() == 0) {
            System.out.println("Información Actualizada");
        } else {
            System.out.println("Error" + respuesta);
        }
    }
    
}
