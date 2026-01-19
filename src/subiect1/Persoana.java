package subiect1;

public abstract class Persoana implements Comparable<Persoana> {
    private String nume;
    private int varsta;
    private double inaltime;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public double getInaltime() {
        return inaltime;
    }

    public void setInaltime(double inaltime) {
        this.inaltime = inaltime;
    }

    public Persoana(String nume, int varsta, double inaltime) {
        this.nume = nume;
        this.varsta = varsta;
        this.inaltime = inaltime;
    }

    public abstract double calculeazaVenit();

    @Override
    public int compareTo(Persoana p) {
        int varstaCmp = Integer.compare(this.varsta, p.varsta);
        if (varstaCmp != 0) {
            return varstaCmp;
        }

        return this.nume.compareTo(p.nume);
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", inaltime=" + inaltime +
                '}';
    }
}

