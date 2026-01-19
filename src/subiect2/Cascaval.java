package subiect2;

public class Cascaval extends Aliment implements Discount {
    private String producator;
    private int calorii;
    private boolean arePachet;

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public int getCalorii() {
        return calorii;
    }

    public void setCalorii(int calorii) {
        this.calorii = calorii;
    }

    public boolean isArePachet() {
        return arePachet;
    }

    public void setArePachet(boolean arePachet) {
        this.arePachet = arePachet;
    }

    public Cascaval(String denumire, double pret, long cod, double greutate, String dataExpirare, boolean esteVegan, String producator, int calorii, boolean arePachet) {
        super(denumire, pret, cod, greutate, dataExpirare, esteVegan);
        this.producator = producator;
        this.calorii = calorii;
        this.arePachet = arePachet;
    }

    public Cascaval(Cascaval c) {
        super(c.getDenumire(), c.getPret(), c.getCod(), c.getGreutate(), c.getDataExpirare(), c.isEsteVegan());
        this.producator = c.producator;
        this.calorii = c.calorii;
        this.arePachet = c.arePachet;
    }

    @Override
    public double aplicaDiscount(boolean esteVegan) {
        double discountVegan = 0.3;
        double disocuntNonVegan = 0.22;
        double pretFinal = 0;

        if (this.isEsteVegan()) {
            pretFinal =  this.getPret() - (this.getPret() * discountVegan);
        } else {
            pretFinal = this.getPret() - (this.getPret() * disocuntNonVegan);
        }

        return pretFinal;
    }

    @Override
    public String genereazaDescriereEtichete(String denumire, double pret, long cod) {
        return "Cascavalul " + denumire + " - " + this.producator + (this.arePachet ? " este ambalat" : " nu este ambalat") + " are " + calorii + " calorii si " + "costa " + pret + " RON.";
    }

    @Override
    public String toString() {
        return "Cascaval{" +
                "producator='" + producator + '\'' +
                ", calorii=" + calorii +
                ", arePachet=" + arePachet +
                "} " + super.toString();
    }
}
