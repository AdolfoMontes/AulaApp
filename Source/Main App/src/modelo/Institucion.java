
package modelo;


public class Institucion {
    private int codigo;
    private int rut;
    private String nombre;
    private String tipo;
    
    public Institucion(){
        this.codigo = 0;
        this.rut = 0;
        this.nombre = ""; 
        this.tipo = "";
    };
    
    public Institucion(int codigo, int rut, String nombre, String tipo){
        this.codigo = codigo;
        this.rut = rut;
        this.nombre = nombre;
        this.tipo = tipo;
    };

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String ToString(){
        return this.getNombre()+  "(" + this.getCodigo() + ")";
    }
}
