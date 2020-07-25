/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class comentarios {
    private int idComentarios;
    private int calificacion;
    private String descripcion;
    private int usuarios_idUsuarios;
    
    public int getIdComentarios() {
        return idComentarios;
    }
    
    public void setiIdComentarios(int idComentarios) {
        this.idComentarios = idComentarios;
    }
    
    public int getCalificacion(){
        return calificacion;
    }
    
    public void setcCalificacion(int calificacion){
        this.calificacion = calificacion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public int getUsuarios_idUsuarios(){
        return usuarios_idUsuarios;
    }
    
    public void setUsuarios_idUsuarios(int usuarios_idUsuarios){
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }
    
}
