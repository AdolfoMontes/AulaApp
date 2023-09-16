

package modelo;

public class Evento extends Persona{
    private int idEvento;
    private String titulo;
    private String detalle;
    private int tipo;
    private String fecha_ins;
    private char estado;
    private String usr_creacion;
    
    public Evento(){
        this.idEvento = 0;
        this.titulo= "";
        this.detalle ="";
        this.tipo = 1;
        this.fecha_ins = "";
        this.estado = 'A';
        this.usr_creacion = "";
    }
    public Evento(int idEvento, String titulo, String detalle, int tipo, String fecha_ins, char estado, String usr_creacion){
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.detalle = detalle;
        this.tipo = tipo;
        this.fecha_ins = fecha_ins;
        this.estado = estado;
        this.usr_creacion=usr_creacion;
    }   

    public int getIdEvento() {
        return idEvento;
    }

    public String getUsr_creacion() {
        return usr_creacion;
    }

    public void setUsr_creacion(String usr_creacion) {
        this.usr_creacion = usr_creacion;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFecha_ins() {
        return fecha_ins;
    }

    public void setFecha_ins(String fecha_ins) {
        this.fecha_ins = fecha_ins;
    }

    @Override
    public char getEstado() {
        return estado;
    }

    @Override
    public void setEstado(char estado) {
        this.estado = estado;
    }
    
}
