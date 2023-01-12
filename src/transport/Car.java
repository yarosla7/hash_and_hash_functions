package transport;

public class Car extends Transport {

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println(getBrand() + " " + getModel() + " started the engine and started moving");
        System.out.println(getBrand() + " is moving right now");
    }

    @Override
    public void endMoving() {
        System.out.println(getBrand() + " " + getModel() + " slows down");
        System.out.println(getBrand() + " " + getModel() + "  has stopped");
    }

    @Override
    public String toString() {
        return "Car{} " + super.toString();
    }
}