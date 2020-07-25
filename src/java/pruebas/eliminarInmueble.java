package pruebas;



import controlador.inmuebleDAO;
import java.util.Scanner;
import modelo.inmuebles;


public class eliminarInmueble {

    public static void main(String[] args) {
        
        inmuebles inmueble = new inmuebles();
        inmuebleDAO inmuebleDAO = new inmuebleDAO();
        Scanner Leer = new Scanner(System.in);

        int idinmueble;

        System.out.println("ingrese el id del inmueble");
        idinmueble = Integer.parseInt(Leer.nextLine());
        inmueble.setIdInmuebles(idinmueble);

        String esta = inmuebleDAO.eliminarInmueblesinmueble(inmueble.getIdInmuebles());
        
        if (esta.length() == 0) {
            
            System.out.println("Información Actualizada");
            
        } else {
            
            System.out.println("Error" + esta);

        }

    }
}
