package modelo;

public class documentos {
    private int idDocumentos;
    private String numeroDocumento;
    private int usuarios_idUsuarios;
    private int tipoDocumentos_idTipoDocumentos;

    public int getIdDocumentos() {
        return idDocumentos;
    }

    public void setIdDocumentos(int idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getUsuarios_idUsuarios() {
        return usuarios_idUsuarios;
    }

    public void setUsuarios_idUsuarios(int usuarios_idUsuarios) {
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }

    public int getTipoDocumentos_idTipoDocumentos() {
        return tipoDocumentos_idTipoDocumentos;
    }

    public void setTipoDocumentos_idTipoDocumentos(int tipoDocumentos_idTipoDocumentos) {
        this.tipoDocumentos_idTipoDocumentos = tipoDocumentos_idTipoDocumentos;
    }

    public void add(documentos documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
