
package modelo;


public class Parentesco {
    private int id;
    private String descripcion;

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

    public Parentesco(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return this.getDescripcion();
    }
}
