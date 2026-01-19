package subiect2;

public abstract class Produs implements Comparable<Produs>{
    private String denumire;
    private double pret;
    private long cod;

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public Produs(String denumire, double pret, long cod) {
        this.denumire = denumire;
        this.pret = pret;
        this.cod = cod;
    }

    public abstract String genereazaDescriereEtichete(String denumire, double pret, long cod);

    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cod=" + cod +
                '}';
    }

    @Override
    public int compareTo(Produs o) {
        int lastCmp = Double.compare(this.pret, o.pret);

        if (lastCmp != 0) {
            return lastCmp;
        }

        return this.denumire.compareTo(o.denumire);
    }
}
