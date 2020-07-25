package pruebas;

import controlador.documentoDAO;
import java.util.Scanner;
import modelo.documentos;

public class agregarDocumento {
    public static void main(String[] args) {
      
        
        documentos documento = new documentos();
        documentoDAO documentoDAO = new documentoDAO();
        Scanner Leer = new Scanner(System.in);
        
        int tipoDocumento;
        String numeroDocumento="";
        int ususario;
        
        
        System.out.println("Por favor numero de documento");
        numeroDocumento = Leer.nextLine();
        documento.setNumeroDocumento(numeroDocumento);
        
        System.out.println("Por favor ingrese el id del usuario");
        ususario = Integer.parseInt(Leer.nextLine());
        documento.setUsuarios_idUsuarios(ususario);
        
        System.out.println("Por favor ingrese el tipo de documento");
        tipoDocumento = Integer.parseInt(Leer.nextLine());
        documento.setTipoDocumentos_idTipoDocumentos(tipoDocumento);
        
        String respuesta = documentoDAO.adicionarDocumentos(documento);       
        
        if (respuesta.length() == 0) {
            
            System.out.println("documento creado!");
            
        } else {
            
            System.out.println("Error en creacion" + respuesta);
        }
    }
}
  