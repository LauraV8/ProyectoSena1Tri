package pruebas;

import controlador.TipoUsuariosDAO;
import modelo.tipousuarios;
import java.util.ArrayList;

public class listarTipoUsuarios {
    
    public static void main(String[] args) {
        TipoUsuariosDAO mitipoUsuariosDao = new TipoUsuariosDAO();
        
        ArrayList<tipousuarios> tipousuarios = new ArrayList<tipousuarios>();
        
        tipousuarios = mitipoUsuariosDao.ConsultarListaTipoUsuarios("");
         
        int size = tipousuarios.size();
        
        System.out.println("<table border= \"1\"><tr><td>IdTipo</td><td>Tipo</td>");

        for (tipousuarios T : tipousuarios){
         System.out.println ("<tr>");
         System.out.println ("<td>" + T.getIdTipoUsuarios() + "<\td>");
         System.out.println ("<td>" + T.getTipoUsuario() + "<\td>");
         System.out.println ("<\tr>");
                
        }
     System.out.println("<\table>");
    }   
}
