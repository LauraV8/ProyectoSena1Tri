package modelo;

public class usuarios {
    private int idUsuarios;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String email;
    private String fechaDeNacimiento;
    private String telefono;
    private String direccion;
    private String contraseña;
    private int tipousuarios_idTipoUsuarios;
    public String acceso;
    
    public int getIdUsuarios() {
        return idUsuarios;
    }
    
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
      public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
      public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
      public String getFechaDeNacimiento(){
        return fechaDeNacimiento;
    }
    
    public void setFechaDeNacimiento(String fechaDeNacimiento){
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
      public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
      public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    
    public int getTipousuarios_idTipoUsuarios() {
        return tipousuarios_idTipoUsuarios;
    }
    
    public void setTipousuarios_idTipoUsuarios(int tipousuarios_idTipoUsuarios) {
        this.tipousuarios_idTipoUsuarios = tipousuarios_idTipoUsuarios;
    }

    public void setIdUsuarios(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
