package transport;

import driver.CheckLicenseException;
import driver.Driver;

import java.util.Objects;

public abstract class Transport<D extends Driver> implements Competing {

    private final String brand;
    private final String model;
    private double engineVolume;
    private final D driver;

    public Transport(String brand, String model, double engineVolume, D driver) {
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

        this.driver = driver; //если объект null
    }

    public Transport(String brand, String model, double engineVolume) {
        this(brand, model, engineVolume, (null));
    } // специальный конструктор, чтобы не переделывать всё в main, ну, и учитывает, что транспорт может быть создан без водителя

    public String getBrand() {
//Лавреньтьев, привет)
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public D getDriver() {
        if (driver == null) {
            throw new RuntimeException("Driver is not created. " + this + " is empty.");
        } else {
            return driver;
        }
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0.0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void startMoving(D driver) throws CheckLicenseException {
        //    getDriver().toDrive();
        if (driver.isHasDrivesLicense()) {
            System.out.println("Driver " + driver.getFullName() + " drives " + this + " and will participate in the race.");
            printType();
            System.out.println(getBrand() + " " + getModel() + " started the engine and started moving on a route with all stops.");
            System.out.println(getBrand() + " is moving right now.");
        } else {
            System.out.println("Driver " + driver.getFullName() + " excluded.");
        }
    }

    public void endMoving() throws CheckLicenseException {
        getDriver().stopVehicle();
        System.out.println(getBrand() + " " + getModel() + " slows down.");
        System.out.println(getBrand() + " " + getModel() + "  has stopped.");
    }

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
        Transport<?> transport = (Transport<?>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) && Objects.equals(driver, transport.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, driver);
    }
// методы интерфейса:

    @Override
    public void pitStop() {
        System.out.println(this + " went to the pit-stop." + getDriver().getFullName() + " is smoking right now.");
    }

    @Override
    public void bestLapTime() {
        System.out.println(this + " has best time lap.");
    }

    @Override
    public void maxSpeed() {
        System.out.println(this + " has maximal speed. " + getDriver().getFullName() + " looks like a winner.");
    }

    @Override
    public void crashed() {
        System.out.println(this + " has been crashed. " + getDriver().getFullName() + " is dead. Game over.");
    } // не самый позитивный сценарий, но, тем не менее, вероятный

    // driver
    public void willParticipate(D driver) throws CheckLicenseException {
        if (driver.isHasDrivesLicense()) {
            System.out.println("Driver " + driver.getFullName() + " drives " + this + " and will participate in the race.");
            printType();
        } else {
            throw new CheckLicenseException("Driver " + driver.getFullName() + " excluded, cause no license found.");
        }
    }

    public abstract void printType();

    public abstract void passDiagnostics() throws CheckLicenseException;
}