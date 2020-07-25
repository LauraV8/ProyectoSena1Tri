/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

public class ciudades {
    private int idCiudades;
    private String nombreCiudad;
    private String nombreDepartamento;
    private String direccion;
    
    public int getIdCiudades() {
        return idCiudades;
    }
    
    public void setIdCiudades(int idCiudades) {
        this.idCiudades = idCiudades;
    }
    
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }
    
    public String getNombreDepartamento(){
        return nombreDepartamento;
    }
    
    public void setNombreDepartamento(String nombreDepartamento){
        this.nombreDepartamento = nombreDepartamento;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
}