package ro.ase.cts.unitestslab.sem13;

public class ContBancar {

    private String nrCont;
    private String nume;
    private double suma;
    private boolean blocat;

    public ContBancar(String nrCont, String nume, double suma, boolean blocat) {
        this.nrCont = nrCont;
        this.nume = nume;
        this.suma = suma;
        this.blocat = blocat;
    }

    public String getNrCont() {
        return nrCont;
    }

    public void setNrCont(String nrCont) {
        this.nrCont = nrCont;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public boolean isBlocat() {
        return blocat;
    }

    public void setBlocat(boolean blocat) {
        this.blocat = blocat;
    }
}
