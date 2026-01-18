package evenimente;

/*
Nota 3-4:
Se defineste o clasa abstracta Event cu atribute private: name, location, ticketPrice.
Clasa contine constructor cu parametri, getteri/setteri, toString si metoda abstracta
calculateRevenue.
Clasa implementeaza Comparable pentru comparare dupa pret si nume.
*/
public abstract class Event implements Comparable<Event> {

    private String name;
    private String location;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event(String name, String location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public abstract double calculateRevenue();

    @Override
    public String toString() {
        return "Eveniment{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Event o) {
        int priceComparison = Double.compare(this.price, o.price);

        if (priceComparison != 0) {
            return priceComparison;
        }

        return this.name.compareTo(o.name);
    }
}
