package pruebas;

import controlador.TipoUsuariosDAO;
import java.util.Scanner;
import modelo.tipousuarios;

public class agregarTipoUsuarios {
    
    public static void main(String[] args) {
        
        tipousuarios mitipousuario = new tipousuarios();
        TipoUsuariosDAO TipoUsuariosDAO = new TipoUsuariosDAO();
        Scanner Leer = new Scanner(System.in);
        
        String tipoUsuarios = "";
        
        System.out.println("Por favor ingrese el nuevo tipo de usuario");
        tipoUsuarios = Leer.nextLine();
        mitipousuario.setTipoUsuario(tipoUsuarios);
        
        String respuesta = TipoUsuariosDAO.adicionarTipoUsuarios(mitipousuario);       
        
        if (respuesta.length() == 0) {
            
            System.out.println("Tipo de Usuario creado!");
            
        } else {
            
            System.out.println("Error en creacion" + respuesta);
        }
    }
}