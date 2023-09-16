

package modelo;


public class Sala {
    private int idSala;
    private String codSala;
    private String piso;
    private char estado;

    public Sala(int idSala, String codSala, String piso, char estado) {
        this.idSala = idSala;
        this.codSala = codSala;
        this.piso = piso;
        this.estado = estado;
    }

    public Sala() {
        this.idSala = 0;
        this.codSala = "";
        this.piso = "";
        this.estado = 'A';
        
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return this.codSala + " | Piso:" + this.getPiso();
    }
}