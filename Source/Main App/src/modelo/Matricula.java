
package modelo;


public class Matricula {
    private int num_matricula;
    private int anio;
    private String fec_matricula;
    private char estado;
    private int nivel;

    public Matricula(int num_matricula, int anio, String fec_matricula, char estado, int nivel) {
        this.num_matricula = num_matricula;
        this.anio = anio;
        this.fec_matricula = fec_matricula;
        this.estado = estado;
        this.nivel = nivel;
    }

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getFec_matricula() {
        return fec_matricula;
    }

    public void setFec_matricula(String fec_matricula) {
        this.fec_matricula = fec_matricula;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
