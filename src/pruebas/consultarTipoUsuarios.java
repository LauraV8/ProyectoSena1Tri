package pruebas;
import controlador.TipoUsuariosDAO;
import modelo.tipousuarios;

public class consultarTipoUsuarios {
    
    public static void main(String[] args) {
        
        TipoUsuariosDAO tipoUsuariosDao = new TipoUsuariosDAO();
        tipousuarios tipoDeUsuarios = tipoUsuariosDao.consultarTipoUsuarios(4);
        
        if(tipoDeUsuarios != null){
            System.out.println("Encontrado el tipo de usuario " + tipoDeUsuarios.getIdTipoUsuarios() + " - " + tipoDeUsuarios.getTipoUsuario());
        } else {
            System.out.println("El tipo de usuario no se encontró");
        }
    }   
}