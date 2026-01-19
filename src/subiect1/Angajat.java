package subiect1;

public class Angajat {
    private float salariu;
    private double bonus;
    private boolean isEligibleForPromotion;

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean isEligibleForPromotion() {
        return isEligibleForPromotion;
    }

    public void setEligibleForPromotion(boolean eligibleForPromotion) {
        isEligibleForPromotion = eligibleForPromotion;
    }

    public Angajat(float salariu, double bonus, boolean isEligibleForPromotion) {
        this.salariu = salariu;
        this.bonus = bonus;
        this.isEligibleForPromotion = isEligibleForPromotion;
    }

    public Angajat(Angajat a) {
        setBonus(a.getBonus());
        setSalariu(a.getSalariu());
        setEligibleForPromotion(a.isEligibleForPromotion());
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "salariu=" + salariu +
                ", bonus=" + bonus +
                ", isEligibleForPromotion=" + isEligibleForPromotion +
                '}';
    }
}
