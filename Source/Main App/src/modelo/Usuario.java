
package modelo;


public class Usuario extends Persona{
    
    private int rut;
    private String codUsuario;
    private String mail;
    private String password;
    private char estado;
    public Usuario(){
        super();
        this.rut = 0;
        this.codUsuario = "";
        this.mail = "";
        this.password = "";
        this.estado = 'A';

    };


    public Usuario(int rut, String codUsuario, String mail, String password){
        this.rut = rut;
        this.codUsuario=codUsuario;
        this.mail = mail;
        this.password=password;
        this.estado = 'A';
    };
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.getPri_nom()+ " " + this.getSeg_nom() + " " + this.getPri_ap() + " " + this.getSeg_ap();
    }
    
    
}
