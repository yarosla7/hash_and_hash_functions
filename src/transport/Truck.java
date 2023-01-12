package transport;

public class Truck extends Transport {
    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    //методы родительского класса:

    @Override
    public void startMoving() {
        System.out.println(getBrand() + " " + getModel() + " started the engine and started moving on a route.");
        System.out.println(getBrand() + " is moving right now.");
    }

    @Override
    public void endMoving() {
        System.out.println(getBrand() + " " + getModel() + " slows down.");
        System.out.println(getBrand() + " " + getModel() + " has stopped.");
    }

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }

    //методы интерфейса в родительском классе. так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.

}
