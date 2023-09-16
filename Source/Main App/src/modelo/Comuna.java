
package modelo;


public class Comuna{
    private int id;
    private String nom_comuna;
    
    public Comuna(int id, String nom_comuna){
        this.id = id;
        this.nom_comuna = nom_comuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_comuna() {
        return nom_comuna;
    }

    public void setNom_comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }

    @Override
    public String toString() {
        return this.nom_comuna;
    }
    
}
