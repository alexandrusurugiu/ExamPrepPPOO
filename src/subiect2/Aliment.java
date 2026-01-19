package subiect2;

public abstract class Aliment extends Produs {
    private double greutate;
    private String dataExpirare;
    private boolean esteVegan;

    public Aliment(String denumire, double pret, long cod) {
        super(denumire, pret, cod);
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public boolean isEsteVegan() {
        return esteVegan;
    }

    public void setEsteVegan(boolean esteVegan) {
        this.esteVegan = esteVegan;
    }

    public Aliment(String denumire, double pret, long cod, double greutate, String dataExpirare, boolean esteVegan) {
        super(denumire, pret, cod);
        this.greutate = greutate;
        this.dataExpirare = dataExpirare;
        this.esteVegan = esteVegan;
    }

    @Override
    public String genereazaDescriereEtichete(String denumire, double pret, long cod) {
        return "Produsul " + cod + " cu denumirea " + denumire + " are pretul de " + pret + " RON";
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "greutate=" + greutate +
                ", dataExpirare='" + dataExpirare + '\'' +
                ", esteVegan=" + esteVegan +
                "} " + super.toString();
    }
}
