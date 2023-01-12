package transport;
import driver.LicenseB;

import java.util.Objects;

public abstract class Transport implements Competing {

    private final String brand;
    private final String model;
    private double engineVolume;

    public Transport(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (model == null || model.isBlank() || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }

        setEngineVolume(engineVolume);
    }

    public String getBrand() {

        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0.0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void startMoving(LicenseB driver) {

    }

    public abstract void startMoving();

    public abstract void endMoving();

    @Override
    public String toString() {
        return brand + ' ' +
                ", model: " + model + ' ' +
                ", engineVolume: " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    // методы интерфейса:

    @Override
    public void pitStop() {
        System.out.println(this + " went to the pit-stop.");
    }

    @Override
    public void bestLapTime() {
        System.out.println(this + " has best time lap.");
    }

    @Override
    public void maxSpeed() {
        System.out.println(this + " has maximal speed.");
    }

    @Override
    public void crashed() {
        System.out.println(this + " has crashed.");
    }
}