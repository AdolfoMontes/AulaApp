
package modelo;


public class Persona extends Rol{
    private int run;
    private char dv;
    private String pri_nom;
    private String seg_nom;
    private String pri_ap;
    private String seg_ap;
    private char estado;
    private String fec_nac;
    private int id_rol;
    private char id_sexo;
    private int num_matricula;
    private int id_pueblo;
    private int id_direccion;
    private int id_curso;
    private int id_discapacidad;
    private String descripcion_curso;
    private String fecha_matricula;
    private int anio_matricula;

    public Persona() {
        super();
        this.run = 0;
        this.dv = '0';
        this.pri_nom = "";
        this.seg_nom = "";
        this.pri_ap = "";
        this.seg_ap = "";
        this.estado = 'A';
        this.fec_nac = "";
        this.id_rol = 0;
        this.id_sexo = 0;
        this.num_matricula = 0;
        this.id_pueblo = 0;
        this.id_direccion = 0;
        this.id_curso = 0;
        this.id_discapacidad = 0;
        this.descripcion_curso = "";
        this.fecha_matricula = "";
        this.anio_matricula = 0;
    }

    public String getDescripcion_curso() {
        return descripcion_curso;
    }

    public void setDescripcion_curso(String descripcion_curso) {
        this.descripcion_curso = descripcion_curso;
    }

    public String getFecha_matricula() {
        return fecha_matricula;
    }

    public void setFecha_matricula(String fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }

    public int getAnio_matricula() {
        return anio_matricula;
    }

    public void setAnio_matricula(int anio_matricula) {
        this.anio_matricula = anio_matricula;
    }


    public Persona(int run, char dv, String pri_nom, String seg_nom, String pri_ap, String seg_ap, char estado, String fec_nac, int id_rol, char id_sexo) {
        this.run = run;
        this.dv = dv;
        this.pri_nom = pri_nom;
        this.seg_nom = seg_nom;
        this.pri_ap = pri_ap;
        this.seg_ap = seg_ap;
        this.estado = estado;
        this.fec_nac = fec_nac;
        this.id_rol = id_rol;
        this.id_sexo = id_sexo;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getPri_nom() {
        return pri_nom;
    }

    public void setPri_nom(String pri_nom) {
        this.pri_nom = pri_nom;
    }

    public String getSeg_nom() {
        return seg_nom;
    }

    public void setSeg_nom(String seg_nom) {
        this.seg_nom = seg_nom;
    }

    public String getPri_ap() {
        return pri_ap;
    }

    public void setPri_ap(String pri_ap) {
        this.pri_ap = pri_ap;
    }

    public String getSeg_ap() {
        return seg_ap;
    }

    public void setSeg_ap(String seg_ap) {
        this.seg_ap = seg_ap;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(String fec_nac) {
        this.fec_nac = fec_nac;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public char getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(char id_sexo) {
        this.id_sexo = id_sexo;
    }

    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }

    public int getId_pueblo() {
        return id_pueblo;
    }

    public void setId_pueblo(int id_pueblo) {
        this.id_pueblo = id_pueblo;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_discapacidad() {
        return id_discapacidad;
    }

    public void setId_discapacidad(int id_discapacidad) {
        this.id_discapacidad = id_discapacidad;
    }
    
    @Override
    public String toString(){
        return this.getRun()+"-"+ this.getDv() + ":" +this.getPri_nom() + " " + this.getSeg_nom() + " " +  this.getPri_ap() + " " + this.getSeg_ap();
    }
    
}
