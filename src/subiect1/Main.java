package subiect1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Manager> manageri = new ArrayList<>();

    static void main() {
        Angajat angajat1 = new Angajat(125566.325f, 50.40, true);
        Angajat angajat2 = new Angajat(663356f, 56, true);
        Angajat angajat3 = new Angajat(1000000f, 76, false);

        System.out.println(angajat1);
        System.out.println(angajat2);
        System.out.println(angajat3);

        Manager m1 = new Manager("Andrei Popescu", 40, 1.80, "IT", 10);
        m1.addAngajat(angajat1);
        Manager m2 = new Manager("Maria Ionescu", 35, 1.68, "Resurse Umane", 3);
        m2.addAngajat(angajat2);
        m2.addAngajat(angajat3);
        Manager m3 = new Manager("Dan Vasile", 52, 1.75, "Vanzari", 25);

        manageri.add(m1);
        manageri.add(m2);
        manageri.add(m3);

        manageri.sort(Manager::compareTo);
        manageri.forEach(System.out::println);

        writeToTextFile(manageri);

        CustomThread ct1 = new CustomThread();
        CustomThread ct2 = new CustomThread();

        ct1.start();
        System.out.println(ct1.getName());
        ct2.start();
        System.out.println(ct2.getName());
    }

    public static void writeToTextFile(List<Manager> manageri) {
        try {
            PrintStream ps = new PrintStream(new File("manageri.txt"));
            for(Manager m : manageri) {
                ps.println(m);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
