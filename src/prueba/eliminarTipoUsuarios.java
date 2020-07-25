package pruebas;
import modelo.tipousuarios;
import controlador.TipoUsuariosDAO;
import java.util.ArrayList;

public class eliminarTipoUsuarios {

    public static void main(String[] args) {
        TipoUsuariosDAO TipoUsuariosDAO = new TipoUsuariosDAO();
        tipousuarios tipousuarios = TipoUsuariosDAO.consultarTipoUsuarios(4);

        if (tipousuarios != null) {

            System.out.println("ID : " + tipousuarios.getIdTipoUsuarios() + "TIPO : " + tipousuarios.getTipoUsuario());
            
        } else {
            System.out.println("El Id del tipo usuario no existe ");
        }

        ArrayList<tipousuarios> listaUsuarios = TipoUsuariosDAO.ConsultarListaTipoUsuarios("");

        for (tipousuarios T : listaUsuarios) {
            
            System.out.println("IdTipoUsuario: " + T.getIdTipoUsuarios() + "IdTipo " + T.getTipoUsuario());
        }
        
        System.out.println("SE ELIMINÓ");
        
        TipoUsuariosDAO.eliminarTipoUsuarios(listaUsuarios.get(2));  
        
         for (tipousuarios T : listaUsuarios) {
            System.out.println("IdTipoUsuario " + T.getIdTipoUsuarios() + "IdTipo " + T.getTipoUsuario());
        }

    }

}
