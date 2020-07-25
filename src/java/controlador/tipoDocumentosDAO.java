
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.tipoDocumentos;

public class tipoDocumentosDAO {

    public tipoDocumentos consultarTipoDocumentos(int idTipoDocumentos){
        tipoDocumentos tipoDocumento = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String Query = "Select idTipoDocumentos, tipoDocumento from tipoDocumentos where idTipoDocumentos = " + idTipoDocumentos;
            ResultSet rs = sentencia.executeQuery(Query);
            while (rs.next()) {
                tipoDocumento = new tipoDocumentos();
                tipoDocumento.setIdTipoDocumentos(rs.getInt(1));
                tipoDocumento.setTipoDocumento(rs.getString(2));
            }
            return tipoDocumento;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return tipoDocumento;
        }
    }
    //Listar TipoDocumentos
    public ArrayList<tipoDocumentos> ConsultarListadoTipoDocumentos(String criterio){
        ArrayList<tipoDocumentos> listadostipodocumentos = new ArrayList<tipoDocumentos>();
        tipoDocumentos miTipoDocumento;

        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        try{
            Statement sentencia = nuevaCon.createStatement();
            String query = "SELECT *" + "FROM tipoDocumentos where tipoDocumento like '%"+ criterio +"%' ORDER BY tipoDocumento";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next()) {
                miTipoDocumento = new tipoDocumentos();
                miTipoDocumento.setIdTipoDocumentos(rs.getInt(1));
                miTipoDocumento.setTipoDocumento(rs.getString(2));
                listadostipodocumentos.add(miTipoDocumento);
            }
            return listadostipodocumentos;
        } catch (Exception ex) {
            System.out.println("Error consulta listado TipoDocumentos: " + ex.getMessage());
            return listadostipodocumentos;
        }
    }
    //Eliminar TipoDocumentos
    public String EliminarTipoDocumentos (tipoDocumentos tipodocumento){
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        PreparedStatement sentencia;
        try{
            String query = "delete from tipoDocumentos where idTipoDocumentos=? and tipoDocumento=?;";
            sentencia = nuevaCon.prepareStatement(query);
            sentencia.setInt(1, tipodocumento.getIdTipoDocumentos());
            sentencia.setString(2, tipodocumento.gettipoDocumento());

            sentencia.execute();
            respuesta = "";

        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en tipoDocumentosDAO.EliminarTipoDocumentos" + ex.getMessage());
        }
        
        return respuesta;
    }
    //Agregar TipoDocumentos
    public String adicionarTipoDocumentos(tipoDocumentos tipodocumento) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO tipoDocumentos (idTipoDocumentos, tipoDocumento)" + "VALUES (null, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, tipodocumento.gettipoDocumento());
        
            sentencia.execute();
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en tipoDocumentosDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    //Editar tipoDocumentos
    public String actualizarTipoDocumentos(tipoDocumentos tipodocumento) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update tipoDocumentos set tipoDocumento=? where idTipoDocumentos=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, tipodocumento.gettipoDocumento());
            sentencia.setInt(2, tipodocumento.getIdTipoDocumentos());
            sentencia.executeUpdate();
            
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en tipoDocumentosDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
}


