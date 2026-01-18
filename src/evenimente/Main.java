package evenimente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Concert> concerts = new ArrayList<Concert>();

    static void main() throws Exception {
        Concert concert1 = new Concert("Rock Fest", "Stadium A", 50.0, "Band A", 3, true, 1000, 200);
        Concert concert2 = new Concert("Jazz Night", "Club B", 30.0, "Artist B", 2, false, 300, 150);
        Concert concert3 = new Concert("Pop Gala", "Arena C", 70.0, "Singer C", 4, true, 2000, 500);
        Concert concert4 = new Concert("Classical Evening", "Hall D", 40.0, "Orchestra D", 2, true, 500, 100);
        Concert concert5 = new Concert("Indie Vibes", "Venue E", 25.0, "Band E", 3, false, 400, 250);
        Concert concert6;
        concert6 = new Concert(concert3);

        Map<Integer, Concert> map = new HashMap<>();
        map.put(1, concert1);
        map.put(2, concert2);
        map.put(3, concert3);
        map.put(4, concert4);
        map.put(5, concert5);
        map.put(6, concert6);


        /*
        NOTA 7:
        Se implementeaza o metoda care opereaza asupra HashMap-ului:
        afisare, calcul venit, modificare locuri.
         */
        printDetails(map);

        double sum = calculateRevenue(map);
        System.out.println(sum);

        changeNumberOfSits(map, "Pop Gala", 30);
        System.out.println(concert3.getBookedSeats());


        /*
        NOTA 8:
        Se creeaza o lista de obiecte Concert, se sorteaza si se afiseaza.
         */
        List<Concert> concertsList = new ArrayList<>(map.values());
        concertsList.sort(Comparable::compareTo);
        concertsList.forEach(System.out::println);


        /*

         */
        try {
            PrintStream ps = new PrintStream(new File("concerts.txt"));
            for (Concert concert : concertsList) {
                ps.println(concert.toString());
            }
        } catch (Exception ex) {
            throw new FileNotFoundException(ex.getMessage());
        }

        /*
        NOTA 10:
        Se defineste un Thread care incearca de maxim 10 ori rezervari random.
        La esec se arunca o exceptie custom.
        Se pornesc doua thread-uri.
         */
        concerts.addAll(concertsList);
        Thread thread1 = new CustomThread();
        Thread thread2 = new CustomThread();
        thread1.start();
        System.out.println("Thread 1 started.");
        thread2.start();
        System.out.println("Thread 2 started.");
    }

    public static void printDetails(Map<Integer, Concert> map) {
        for (var entry : map.entrySet()) {
            System.out.println("The revenue for the concert " + entry.getKey() + " is " + entry.getValue().calculateRevenue());
        }
    }

    public static double calculateRevenue(Map<Integer, Concert> map) {
        double sum = 0;

        for (var entry : map.entrySet()) {
            sum += entry.getValue().calculateRevenue();
        }

        return sum;
    }

    public static void changeNumberOfSits(Map<Integer, Concert> map, String concertName,int newNumberOfTickets) throws Exception {
        for (var entry : map.entrySet()) {
            if (entry.getValue().getName().equals(concertName)) {
                try {
                    entry.getValue().bookTickets(newNumberOfTickets);
                } catch (RuntimeException e) {
                    throw new Exception("You can't book more tickets for this event");
                }
            }
        }
    }
}
