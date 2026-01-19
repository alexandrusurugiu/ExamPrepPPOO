package subiect1;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Persoana implements Impozit {
    private List<Angajat> listaAngajati;
    private String departament;
    private int dimensiuneEchipa;

    public List<Angajat> getListaAngajati() {
        return listaAngajati;
    }

    public void addAngajat(Angajat angajat) {
        this.listaAngajati.add(angajat);
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public int getDimensiuneEchipa() {
        return dimensiuneEchipa;
    }

    public void setDimensiuneEchipa(int dimensiuneEchipa) {
        this.dimensiuneEchipa = dimensiuneEchipa;
    }

    public Manager(String nume, int varsta, double inaltime, String departament, int dimensiuneEchipa) {
        super(nume, varsta, inaltime);
        this.departament = departament;
        this.dimensiuneEchipa = dimensiuneEchipa;
        this.listaAngajati = new ArrayList<>();
    }

    @Override
    public double calculeazaImpozit(float salariu) {
        return salariu / (dimensiuneEchipa*0.1);
    }

    @Override
    public double calculeazaVenit() {
        return 5000.0f + (dimensiuneEchipa * 200.0f);
    }

    public void stergeAngajati(List<Angajat> angajati, float salariu) {
        angajati.removeIf(a -> a.getSalariu() < salariu);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "listaAngajati=" + listaAngajati +
                ", departament='" + departament + '\'' +
                ", dimensiuneEchipa=" + dimensiuneEchipa +
                "} " + super.toString();
    }
}
