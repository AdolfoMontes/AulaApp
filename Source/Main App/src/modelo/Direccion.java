

package modelo;

    
public class Direccion{
    private int id;
    private String descripcion;
    private int id_comuna;
    private String nom_comuna;
    private String nom_region;
    
    public Direccion(){
    this.id = 0;
    this.descripcion="";
    this.id_comuna = 0;
    this.nom_comuna = "";
    this.nom_region = "";
    }

    public Direccion(int id, String descripcion, int id_comuna, String nom_comuna, String nom_region) {
        this.id = id;
        this.descripcion = descripcion;
        this.id_comuna = id_comuna;
        this.nom_comuna = nom_comuna;
        this.nom_region = nom_region;
    }

    public String getNom_comuna() {
        return nom_comuna;
    }

    public void setNom_comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
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

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }
    
    
}
