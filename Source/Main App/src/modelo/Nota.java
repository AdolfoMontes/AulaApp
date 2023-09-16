

package modelo;


public class Nota extends Persona{
    private int id_nota;
    private int run;
    private int id_asignatura;
    private int anio;
    private float n1;
    private float n2;
    private float n3;
    private float n4;
    private float n5;
    private float n6;
    private float n7;
    private float n8;
    private float n9;
    private float n10;
    private float n11;
    private float n12;
    private float n13;
    private float n14;
    private float n15;
    private float n16;
    private float n17;
    private float n18;
    private float n19;
    private float n20;
    private float p1;
    private float p2;
    private float pf;
    private char estado;
    
    public Nota(){
        this.id_nota = 0;
        this.run = 0;
        this.id_asignatura = 0;
        this.anio = 0;
        this.n1 = 0;
        this.n2 = 0;
        this.n3 = 0;
        this.n4 = 0;
        this.n5 = 0;
        this.n6 = 0;
        this.n7 = 0;
        this.n8 = 0;
        this.n9 = 0;
        this.n10 = 0;
        this.n11 = 0;
        this.n12 = 0;
        this.n13 = 0;
        this.n14 = 0;
        this.n15 = 0;
        this.n16 = 0;
        this.n17 = 0;
        this.n18 = 0;
        this.n19 = 0;
        this.n20 = 0;
        this.p1 = 0;
        this.p2 = 0;
        this.pf = 0;
        this.estado = 'A';
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    public float getN3() {
        return n3;
    }

    public void setN3(float n3) {
        this.n3 = n3;
    }

    public float getN4() {
        return n4;
    }

    public void setN4(float n4) {
        this.n4 = n4;
    }

    public float getN5() {
        return n5;
    }

    public void setN5(float n5) {
        this.n5 = n5;
    }

    public float getN6() {
        return n6;
    }

    public void setN6(float n6) {
        this.n6 = n6;
    }

    public float getN7() {
        return n7;
    }

    public void setN7(float n7) {
        this.n7 = n7;
    }

    public float getN8() {
        return n8;
    }

    public void setN8(float n8) {
        this.n8 = n8;
    }

    public float getN9() {
        return n9;
    }

    public void setN9(float n9) {
        this.n9 = n9;
    }

    public float getN10() {
        return n10;
    }

    public void setN10(float n10) {
        this.n10 = n10;
    }

    public float getN11() {
        return n11;
    }

    public void setN11(float n11) {
        this.n11 = n11;
    }

    public float getN12() {
        return n12;
    }

    public void setN12(float n12) {
        this.n12 = n12;
    }

    public float getN13() {
        return n13;
    }

    public void setN13(float n13) {
        this.n13 = n13;
    }

    public float getN14() {
        return n14;
    }

    public void setN14(float n14) {
        this.n14 = n14;
    }

    public float getN15() {
        return n15;
    }

    public void setN15(float n15) {
        this.n15 = n15;
    }

    public float getN16() {
        return n16;
    }

    public void setN16(float n16) {
        this.n16 = n16;
    }

    public float getN17() {
        return n17;
    }

    public void setN17(float n17) {
        this.n17 = n17;
    }

    public float getN18() {
        return n18;
    }

    public void setN18(float n18) {
        this.n18 = n18;
    }

    public float getN19() {
        return n19;
    }

    public void setN19(float n19) {
        this.n19 = n19;
    }

    public float getN20() {
        return n20;
    }

    public void setN20(float n20) {
        this.n20 = n20;
    }

    public float getP1() {
        return p1;
    }

    public void setP1(float p1) {
        this.p1 = p1;
    }

    public float getP2() {
        return p2;
    }

    public void setP2(float p2) {
        this.p2 = p2;
    }

    public float getPf() {
        return pf;
    }

    public void setPf(float pf) {
        this.pf = pf;
    }


    

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "RUN Alumno: " + this.getRun() + "| Nombre: " + this.getPri_ap() + ", "+ this.getPri_nom() + "| Nota Final (Parcial)->" + this.getPf();
    }
    
    
}