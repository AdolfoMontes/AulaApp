

package modelo;


public class Asignatura extends Persona{
        private int id_asignatura;
        private String nom_asignatura;
        private String cod_asignatura;
        private int anio;
        private char estado;
        private int calculo;
        private int id_curso;
        private int id_sala;
        private int doc_asignado;

        public Asignatura(){
            this.id_asignatura = 0;
            this.nom_asignatura = "";
            this.cod_asignatura = "";
            this.anio = 0;
            this.estado = 'A';
            this.calculo = 0;
            this.id_curso = 0;
            this.id_sala = 0;
            this.doc_asignado = 0;
        }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNom_asignatura() {
        return nom_asignatura;
    }

    public void setNom_asignatura(String nom_asignatura) {
        this.nom_asignatura = nom_asignatura;
    }

    public String getCod_asignatura() {
        return cod_asignatura;
    }

    public void setCod_asignatura(String cod_asignatura) {
        this.cod_asignatura = cod_asignatura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

   @Override
    public char getEstado() {
        return estado;
    }

    @Override
    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getCalculo() {
        return calculo;
    }

    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getDoc_asignado() {
        return doc_asignado;
    }

    public void setDoc_asignado(int doc_asignado) {
        this.doc_asignado = doc_asignado;
    }
    
    @Override
    public String toString(){
        String estado =""; 
        if(this.getEstado()=='F'){
            estado = " (Finalizada)";
        }
        return this.getCod_asignatura() + " - " + this.getNom_asignatura() + estado;
    }
        
}