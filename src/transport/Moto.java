package transport;

public class Moto extends Transport {

    public Moto(String brand, String model, int year, String country, String color, int maxSpeed) {
        super(brand, model, year, country, color, maxSpeed);
    }

    public Moto(String brand, String model, int year, String country) {
        super(brand, model, year, country);
        setMaxSpeed(0);
        setColor("black");
    }

    @Override
    public String toString() {
        return "Moto{} " + super.toString();
    }
}