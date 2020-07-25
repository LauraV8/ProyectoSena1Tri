package modelo;

public class inmuebles {
    private int idInmuebles;
    private String nombre;
    private int precioAlquiler;
    private String descripcion;
    private int tipoinmuebles_idTipoInmuebles;
    private int usuarios_idUsuarios;
    private int ciudades_idCiudades;
    
    public int getIdInmuebles() {
        return idInmuebles;
    }
    
    public void setIdInmuebles(int idInmuebles) {
        this.idInmuebles = idInmuebles;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getPrecioAlquiler() {
    return precioAlquiler;
    }
    
    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public int getTipoinmuebles_idTipoInmuebles() {
        return tipoinmuebles_idTipoInmuebles;
    }
    
    public void setTipoinmuebles_idTipoInmuebles(int tipoinmuebles_idTipoInmuebles) {
        this.tipoinmuebles_idTipoInmuebles = tipoinmuebles_idTipoInmuebles;
    }
    
    public int getUsuarios_idUsuarios() {
        return usuarios_idUsuarios;
    }
    
    public void setUsuarios_idUsuarios(int usuarios_idUsuarios) {
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }
    
    public int getCiudades_idCiudades() {
        return ciudades_idCiudades;
    }
    
    public void setCiudades_idCiudades(int ciudades_idCiudades) {
        this.ciudades_idCiudades = ciudades_idCiudades;
    }
}

