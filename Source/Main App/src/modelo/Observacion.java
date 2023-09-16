
package modelo;


public class Observacion {
        private int idObservacion;
        private String tipo;
        private String descripcion;
        private String fechaIns;
        private String usrCreacion;
        private int run;
        private int idCurso;
        
        public Observacion(){
            this.idObservacion = 0;
            this.tipo = "";
            this.descripcion = "";
            this.fechaIns = "";
            this.usrCreacion = "";
            this.run = 0;
            this.idCurso = 0;
                   
        }

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(String fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getUsrCreacion() {
        return usrCreacion;
    }

    public void setUsrCreacion(String usrCreacion) {
        this.usrCreacion = usrCreacion;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

}