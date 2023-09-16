
package modelo;


public class Sexo {
    
    private char id;
    private String descripcion;
    
    public Sexo(char id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
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
        return this.descripcion;
    }
}
