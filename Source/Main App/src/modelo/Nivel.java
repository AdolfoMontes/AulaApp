
package modelo;


public class Nivel {
    private int id;
    private String descripcion;

    public Nivel() {
        this.id = 0;
        this.descripcion ="";
    }

    public Nivel(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString(){
        return this.getDescripcion();
    }
    
}
