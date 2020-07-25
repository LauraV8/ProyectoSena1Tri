
package pruebas;

import modelo.tipoinmuebles;
import controlador.tipoInmueblesDAO;
public class consultarTipoInmuebles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        tipoInmueblesDAO tipoinmuebleDAO = new tipoInmueblesDAO();
        tipoinmuebles tipoinmuebles = tipoinmuebleDAO.consultarTipoInmuebles(3);
        
        if(tipoinmuebles != null){
            System.out.println("Encontrado el Id del inmueble: " + tipoinmuebles.getIdTipoInmuebles());
            System.out.println("Encontrado el nombre del inmueble: " + tipoinmuebles.getTipoInmueble());
      
        } else {
            System.out.println("El usuario no se encontró");
        }
    }   
 }
   

