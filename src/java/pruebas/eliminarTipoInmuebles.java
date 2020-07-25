package pruebas;

import controlador.tipoInmueblesDAO;
import java.util.Scanner;
import modelo.tipoinmuebles;

/**
 *
 * @author abaddon
 */
public class eliminarTipoInmuebles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        tipoinmuebles inmueble = new tipoinmuebles();
        tipoInmueblesDAO inmuebleDAO = new tipoInmueblesDAO();
        Scanner Leer = new Scanner(System.in);

        int idinmueble;

        System.out.println("ingrese el id del tipo de inmueble");
        idinmueble = Integer.parseInt(Leer.nextLine());
        inmueble.setIdTipoInmuebles(idinmueble);

        String esta = inmuebleDAO.eliminarInmueblesinmueble(inmueble.getIdTipoInmuebles());
        
        if (esta.length() == 0) {
            
            System.out.println("Información Actualizada");
            
        } else {
            
            System.out.println("Error" + esta);

        }

    }
}
