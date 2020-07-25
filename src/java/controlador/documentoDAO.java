package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.documentos;
import java.util.ArrayList;

public class documentoDAO {

    public documentos consultarDocumento(int idDocumentos){
        
        documentos documento = null;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();

        try{
            
            Statement sentencia = nuevaCon.createStatement();
            
            String Query = "Select idDocumentos, numeroDocumento, usuarios_idUsuarios, tipoDocumentos_idTipoDocumentos  from documentos where idDocumentos = " + idDocumentos;
            
            ResultSet rs = sentencia.executeQuery(Query);
            
            while (rs.next()) {
                
                documento = new documentos();
                documento.setIdDocumentos(rs.getInt(1));
                documento.setNumeroDocumento(rs.getString(2));
                documento.setUsuarios_idUsuarios(rs.getInt(3));
                documento.setTipoDocumentos_idTipoDocumentos(rs.getInt(4));
                
            }
            
            return documento;
        }
        
        catch (Exception ex) {
            
            System.out.println(ex.getMessage());
            
            return documento;
        }
    }
    
    public ArrayList<documentos>listarDocumento(String criterio) {

    ArrayList <documentos> listarDocumentos= new ArrayList <documentos>();

        documentos documento;
        Conexion conexion = new Conexion ();
        Connection nuevaCon;
        nuevaCon=conexion.getConn();
       try{
           
           Statement sentencia=nuevaCon.createStatement();
           
           String Query = "SELECT *" + "FROM documentos where numeroDocumento like '%"+ criterio +"%' ORDER BY numeroDocumento";
                                    
           ResultSet rs = sentencia.executeQuery(Query);
           
           while(rs.next()){
                                            
                documento = new documentos();
                documento.setIdDocumentos(rs.getInt(1));
                documento.setNumeroDocumento(rs.getString(2));
                documento.setTipoDocumentos_idTipoDocumentos(rs.getInt(3));
                listarDocumentos.add(documento);
                
                }
                return listarDocumentos;
                    
         }catch(Exception ex) {
             
            System.out.println("error al consultar listado Documentos " + ex.getMessage());
            
            return listarDocumentos;
    }
}
    
    public String EliminarDocumentos (documentos documento){
        
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();

        PreparedStatement sentencia;
        try{
            String query = "delete from documentos where idDocumentos=?;";
            
            sentencia = nuevaCon.prepareStatement(query);
            sentencia.setInt(1,documento.getIdDocumentos());
            sentencia.execute();
            respuesta = "";

        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en DocumentoDAO.Eliminar Documentos" + ex.getMessage());
        }
        
        return respuesta;
    }

    public String adicionarDocumentos(documentos documento) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO documentos (idDocumentos, numeroDocumento, tipoDocumentos_idTipoDocumentos, usuarios_idUsuarios)" + "VALUES (null, ?, ?, ?)";

            sentencia = nuevaCon.prepareStatement(Query);
            
            sentencia.setString(1, documento.getNumeroDocumento());
            sentencia.setInt(2,documento.getTipoDocumentos_idTipoDocumentos());
            sentencia.setInt(3,documento.getUsuarios_idUsuarios());
            
            sentencia.execute();
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrió un error en DocumentosDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
    
    
    
    
    

    public String actualizarDocumentos(documentos documento) {
        String respuesta;
        Conexion conexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = conexion.getConn();
        PreparedStatement sentencia;

        try {
            String Query = "update documentos set numeroDocumento=?  where idDocumentos=?";

            sentencia =  nuevaCon.prepareStatement(Query);

            sentencia.setString(1, documento.getNumeroDocumento());
            sentencia.setInt(2, documento.getIdDocumentos());
            sentencia.executeUpdate();
            
            respuesta = "";
            
        } catch (Exception ex) {
            respuesta = ex.getMessage();
            System.err.println("Ocurrio un error en DocumentosDAO\n" + ex.getMessage());
        }
        return respuesta;
    }
}


