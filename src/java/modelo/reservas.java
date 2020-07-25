/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class reservas {
    private int idReservas;
    private String estancia;
    private int cantidadDePersonas;
    private String ingreso;
    private String salida;
    private int inmuebles_idInmuebles;
    private int Usuarios_idUsuarios;
    private int estadoreservas_idEstadoReservas;
    
    public int getIdReservas() {
        return idReservas;
    }
    
    public void setIdReservas(int idReservas) {
        this.idReservas = idReservas;
    }
    
    public String getEstancia(){
        return estancia;
    }
    
    public void setEstancia(String estancia){
        this.estancia = estancia;
    }
    
    public int getCantidadDePersonas() {
    return cantidadDePersonas;
    }
    
    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
    
    public String getIngreso(){
        return ingreso;
    }
    
    public void setIngreso(String ingreso){
        this.ingreso = ingreso;
    }
    
    public String getSalida(){
        return salida;
    }
    
    public void setSalida(String salida){
        this.salida = salida;
    }
    
    public int getInmuebles_idInmuebles() {
        return inmuebles_idInmuebles;
    }
    
    public void setInmuebles_idInmuebles(int inmuebles_idInmuebles) {
        this.inmuebles_idInmuebles = inmuebles_idInmuebles;
    }
    
    public int getUsuarios_idUsuarios() {
        return Usuarios_idUsuarios;
    }
    
    public void setUsuarios_idUsuarios(int Usuarios_idUsuarios) {
        this.Usuarios_idUsuarios = Usuarios_idUsuarios;
    }
    
    public int getEstadoreservas_idEstadoReservas() {
        return estadoreservas_idEstadoReservas;
    }
    
    public void setEstadoreservas_idEstadoReservas(int estadoreservas_idEstadoReservas) {
        this.estadoreservas_idEstadoReservas = estadoreservas_idEstadoReservas;
    }
    
}
