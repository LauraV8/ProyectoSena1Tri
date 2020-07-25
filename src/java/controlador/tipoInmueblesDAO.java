package controlador;

import modelo.tipoinmuebles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class tipoInmueblesDAO {
    
    public String adicionarTipoInmueble(tipoinmuebles tipoinmueble) {
    
        String esta;
        Conexion Conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = Conexion.getConn();
        PreparedStatement sentencia;
        
        try {
            String Query = "INSERT INTO tipoinmuebles (idTipoInmuebles, tipoInmueble)" + "VALUES (null, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            
            
            sentencia.setString(1, tipoinmueble.getTipoInmueble());
            sentencia.execute();
            esta = "";
            
        } catch (Exception ex) {
    
            esta = ex.getMessage();
            System.err.println("Ocurrió un error en tipo de inmuebleDAO\n" + ex.getMessage());
        }
        
        return esta;
    }

    public String actualizartipoInmueble(tipoinmuebles tipoinmueble) {
        
        String esta;
        
        Conexion Conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = Conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update tipoinmuebles set tipoInmueble=? where idTipoInmuebles=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, tipoinmueble.getTipoInmueble());
            sentencia.setInt(2, tipoinmueble.getIdTipoInmuebles());

            sentencia.executeUpdate();
            esta = "";
            
        } catch (Exception ex) {
            esta = ex.getMessage();
            System.err.println("Ocurrio un error en inmuebles\n" + ex.getMessage());
        }
        return esta;
    }

    public String eliminarInmueblesinmueble(int id) {
        String sql = "delete from  tipoinmuebles where idTipoInmuebles=" + id;
               
        String esta;
        
        try {
            
            Conexion Conexion = new Conexion();
            Connection nuevaCon;
            nuevaCon = Conexion.getConn();
            PreparedStatement sentencia;
            sentencia =  nuevaCon.prepareStatement(sql);
            sentencia.executeUpdate();
            esta = "";
            
        } catch (Exception ex) {
            
            esta = ex.getMessage();
            System.err.println("Ocurrio un error en inmuebles\n" + ex.getMessage());
        }
        return esta;

    }
        public tipoinmuebles consultarTipoInmuebles(int idTipoInmuebles){
        tipoinmuebles  tipoinmueble = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idtipoinmuebles, tipoInmueble from tipoinmuebles where  idTipoInmuebles = " + idTipoInmuebles;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                
                tipoinmueble = new tipoinmuebles();
                
                tipoinmueble.setIdTipoInmuebles(rs.getInt(1));
                tipoinmueble.setTipoInmueble(rs.getString(2));

                         
            }
            return tipoinmueble;
        }
        catch (Exception ex) {
            System.out.println("Error en consulta de inmueble"+ ex.getMessage());
            return tipoinmueble;
            
        }
    }
        
    public ArrayList<tipoinmuebles> ListarInmuebles(String criterio){
        ArrayList<tipoinmuebles> listadoInmuebles = new ArrayList<tipoinmuebles>();
        tipoinmuebles tipoinmuebles;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String query = "SELECT *" + "FROM tipoinmuebles where tipoInmueble like '%"+ criterio +"%' ORDER BY tipoInmueble";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()) {
                
                tipoinmuebles = new tipoinmuebles();
                
                tipoinmuebles.setIdTipoInmuebles(rs.getInt(1));
                tipoinmuebles.setTipoInmueble(rs.getString(2));
                listadoInmuebles.add(tipoinmuebles);
                
            }
            return listadoInmuebles;
            
        } catch (Exception ex) {
            System.out.println("Error consulta listado reservas: " + ex.getMessage());
            return listadoInmuebles;
        }
    }
}


    

