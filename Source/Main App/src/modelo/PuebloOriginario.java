
package modelo;


public class PuebloOriginario {
    private int id;
    private String nom_pueblo;
    
    public PuebloOriginario(int id, String nom_pueblo){
        this.id = id;
        this.nom_pueblo = nom_pueblo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_pueblo() {
        return nom_pueblo;
    }

    public void setNom_pueblo(String nom_pueblo) {
        this.nom_pueblo = nom_pueblo;
    }

    @Override
    public String toString() {
        return this.nom_pueblo;
    }
    
}
