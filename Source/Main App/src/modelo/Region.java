
package modelo;


public class Region {
    private int id;
    private String nom_region;
    
    public Region(int id, String nom_region){
        this.id = id;
        this.nom_region = nom_region;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    @Override
    public String toString() {
        return this.getNom_region();
    }
    
}
