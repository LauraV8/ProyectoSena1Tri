package pruebas;

import modelo.tipoinmuebles;
import controlador.tipoInmueblesDAO;
import java.util.Scanner;


public class agregartipoinmueble {

    public static void main(String[] args) {
        
        tipoinmuebles tipoinmueble = new tipoinmuebles();
        tipoInmueblesDAO tipoinmuebleDAO = new tipoInmueblesDAO();
        Scanner Leer = new Scanner(System.in);
        
        String tipoInmueble;


        System.out.println("Por favor ingrese un nuevo tipo de inmueble");
        tipoInmueble = Leer.nextLine();
        tipoinmueble.setTipoInmueble(tipoInmueble);
          
        
        String esta = tipoinmuebleDAO.adicionarTipoInmueble(tipoinmueble);
        

        if (esta.length() == 0) {
            
            System.out.println("tipo de inmueble creado!");
            
        } else {
            
            System.out.println("Error" + esta);
        }
        
    }
}

