package evenimente;

/*
NOTA 6:
Se defineste clasa Concert care extinde MusicEvent si implementeaza Bookable.
Atribute: totalSeats, bookedSeats.
Se implementeaza constructor, constructor de copiere, toString si metodele abstracte.
 */
public class Concert extends MusicEvent implements Bookable {

    private int totalSeats;
    private int bookedSeats;

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Concert(String name, String location, double price, String artist, int durationHours, boolean indoor, int totalSeats, int bookedSeats) {
        super(name, location, price, artist, durationHours, indoor);
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
    }

    public Concert(Concert c){
        this(c.getName(), c.getLocation(), c.getPrice(), c.getArtist(), c.getDurationHours(), c.isIndoor(), c.totalSeats, c.bookedSeats);
    }

    @Override
    public void bookTickets(int numberOfTickets) {
        if (this.bookedSeats + numberOfTickets < this.totalSeats) {
            this.bookedSeats += numberOfTickets;
        }
    }

    @Override
    public double calculateRevenue() {
        return bookedSeats * getPrice();
    }

    @Override
    public String toString() {
        return "Concert{" +
                "totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                "} " + super.toString();
    }
}
