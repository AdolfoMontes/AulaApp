
package modelo;


public class Curso extends Nivel{
    private int id_curso;
    private String cod_curso;
    private String nom_curso;
    private int cantidad_max;
    private int nivel;
    private int anio;
    private int alumnosActuales;
    private String nombreDocente;

    public Curso() {
        super();
        this.id_curso = 0;
        this.cod_curso = "";
        this.nom_curso = "";
        this.cantidad_max = 0;
        this.nivel = 0;
        this.anio=0;
        this.nivel=0;
        this.alumnosActuales=0;
        this.nombreDocente ="";
        
    }

    public int getAlumnosActuales() {
        return alumnosActuales;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public void setAlumnosActuales(int alumnosActuales) {
        this.alumnosActuales = alumnosActuales;
    }

    public Curso(int id_curso, String cod_curso, String nom_curso, int cantidad_max, int nivel, int anio) {
        
        this.id_curso = id_curso;
        this.cod_curso = cod_curso;
        this.nom_curso = nom_curso;
        this.cantidad_max = cantidad_max;
        this.nivel = nivel;
        this.anio = anio;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNom_curso() {
        return nom_curso;
    }

    public void setNom_curso(String nom_curso) {
        this.nom_curso = nom_curso;
    }

    public int getCantidad_max() {
        return cantidad_max;
    }

    public void setCantidad_max(int cantidad_max) {
        this.cantidad_max = cantidad_max;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    @Override
    public String toString(){
        return this.getCod_curso() + "(" + this.getAnio()+")" + " | " + this.getAlumnosActuales() + "/" + this.getCantidad_max() ;
    }
    
}
