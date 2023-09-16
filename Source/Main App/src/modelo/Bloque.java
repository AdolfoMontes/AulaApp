

package modelo;


public class Bloque{
    private int id_bloque;
    private String hora_ini;
    private String hora_ter;
    private int dia_semana;
    private char estado;
    private boolean asignado;
    
    public Bloque(){
        this.id_bloque = 0;
        this.hora_ini = "";
        this.hora_ter = "";
        this.dia_semana = 0;
        this.estado ='A';
        this.asignado = false;
        
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public int getId_bloque() {
        return id_bloque;
    }

    public void setId_bloque(int id_bloque) {
        this.id_bloque = id_bloque;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getHora_ter() {
        return hora_ter;
    }

    public void setHora_ter(String hora_ter) {
        this.hora_ter = hora_ter;
    }

    public int getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    public String diaSemana(){
        String retorno = "" ;
        switch(this.getDia_semana()){
            case 1: 
                retorno = "Lun";
                break;
            case 2: 
                retorno = "Mar";
                break;
            case 3: 
                retorno = "Mie";
                break;
            case 4: 
                retorno = "Jue";
                break;
            case 5: 
                retorno = "Vie";
                break;
            case 6: 
                retorno = "Sab";
                break;
            case 7: 
                retorno = "Dom";
                break;
        }
        return retorno;
    }
    
    public String toString(){
        return this.getHora_ini() + " - " + this.getHora_ter();
    }
}