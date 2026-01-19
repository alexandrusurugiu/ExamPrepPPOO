package subiect2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() {

        Cascaval c1 = new Cascaval("Dalia", 24.50, 101L, 0.450, "20-06-2024", false, "Napolact", 320, true);
        Cascaval c2 = new Cascaval("Afumat Superior", 55.99, 102L, 1.0, "15-08-2024", false, "Sibiu", 350, true);
        Cascaval c3 = new Cascaval("VioLife Aroma", 42.00, 103L, 0.200, "10-12-2025", true, "VioLife", 270, true);
        Cascaval c4 = new Cascaval("Gouda Vrac", 12.50, 104L, 0.300, "05-02-2024", false, "NoName", 340, false);
        Cascaval c5 = new Cascaval("Rucar", 9.99, 105L, 0.150, "01-04-2024", false, "Hochland", 310, true);

        Map<Long, Cascaval> map = new HashMap<>();
        map.put(c1.getCod(), c1);
        map.put(c2.getCod(), c2);
        map.put(c3.getCod(), c3);
        map.put(c4.getCod(), c4);
        map.put(c5.getCod(), c5);

        modificaProdusVegan(map);

        Cascaval c6 = new Cascaval("Parmigiano Reggiano", 85.00, 201L, 0.250, "30-12-2025", true, "Zanetti", 431, true);
        Cascaval c7 = new Cascaval("Cascaval Light", 29.50, 202L, 0.400, "15-06-2024", false, "Hochland", 260, true);
        Cascaval c8 = new Cascaval("Cascaval de Saveni", 65.00, 203L, 0.500, "01-05-2024", false, "Produs Local", 320, false);
        Cascaval c9 = new Cascaval("Bloc Vegan Cheddar", 38.90, 204L, 0.200, "20-11-2024", true, "SimplyV", 285, true);
        Cascaval c10 = new Cascaval("Toast Felii", 8.50, 205L, 0.150, "10-09-2024", false, "Delaco", 305, true);

        List<Cascaval> listaCascavaluri = new ArrayList<>();
        listaCascavaluri.add(c6);
        listaCascavaluri.add(c7);
        listaCascavaluri.add(c8);
        listaCascavaluri.add(c9);
        listaCascavaluri.add(c10);

        listaCascavaluri.sort(Produs::compareTo);
        listaCascavaluri.forEach(System.out::println);

        System.out.println(c6.genereazaDescriereEtichete(c6.getDenumire(), c6.getPret(), c6.getCod()));
        c6.aplicaDiscount(c6.isEsteVegan());
        System.out.println(c7.genereazaDescriereEtichete(c7.getDenumire(), c7.getPret(), c6.getCod()));
        c7.aplicaDiscount(c7.isEsteVegan());
        System.out.println(c8.genereazaDescriereEtichete(c8.getDenumire(), c8.getPret(), c8.getCod()));
        c8.aplicaDiscount(c8.isEsteVegan());
        System.out.println(c9.genereazaDescriereEtichete(c9.getDenumire(), c9.getPret(), c9.getCod()));
        c9.aplicaDiscount(c9.isEsteVegan());
        System.out.println(c10.genereazaDescriereEtichete(c10.getDenumire(), c10.getPret(), c10.getCod()));
        c10.aplicaDiscount(c10.isEsteVegan());

        scrieFisierText(map);
    }

    public static void modificaProdusVegan(Map<Long, Cascaval> map) {
        for (var entry : map.entrySet()) {
            if (entry.getValue().isEsteVegan()) {
                entry.getValue().setCalorii(entry.getValue().getCalorii() - 20);

                if (entry.getValue().getPret() < 40) {
                    entry.getValue().setPret(entry.getValue().getPret() + 13.20);
                }
            }
        }
    }

    public static void scrieFisierText(Map<Long, Cascaval> map) {
        try {
            PrintStream ps = new PrintStream(new File("cascavaluri.txt"));
            for (var entry : map.entrySet()) {
                ps.println(entry.getValue());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
