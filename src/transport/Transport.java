package transport;

import driver.CheckLicenseException;
import driver.Driver;
import transport.stuff.Mechanic;

import java.util.*;

public abstract class Transport<D extends Driver> implements Competing {

    private final String brand;
    private final String model;
    private double engineVolume;
    private final D driver;
    private final Map<Transport<?>, Mechanic<?>> carsAndMechanicList = new HashMap<>();
    private final List<Mechanic<?>> defaultMechanic = new ArrayList<>(); // чтобы механик всегда был

    public List<Mechanic<?>> getDefaultMechanic() {
        return defaultMechanic;
    }

    public Transport(String brand, String model, D driver) {
        this.brand = brand;
        this.model = model;
        this.driver = driver;
    }

    public Transport(String brand,
                     String model,
                     double engineVolume,
                     D driver) {
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

        this.driver = driver;

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

    //list

    public Map<Transport<?>, Mechanic<?>> getMechanicsList() {
        return carsAndMechanicList;
    }

    public void addMechanics(Transport<?> transport, Mechanic<?> mechanic) {
        if (transport == null || carsAndMechanicList.containsKey(transport)) {
            carsAndMechanicList.put(transport, mechanic);
            System.out.println("For " + transport.getBrand() + " " + transport.getModel() + " set new mechanic. Mechanic's name is " + mechanic.getName() + " and company is " + mechanic.getCompany() + ".");
        } else {
            System.out.println("Transport is not found.");
        }
    } // я тупой))

    public void addDefMec(Mechanic<?> mechanic) {
        defaultMechanic.add(mechanic);
    }

    @Override
    public String toString() {
        return "Transport: " +
                "brand is " + brand + " model is " + model + '.' +
                " EngineVolume equals " + engineVolume +
                ", and driver of this vehicle is " + driver + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?> transport = (Transport<?>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) && Objects.equals(driver, transport.driver) && Objects.equals(carsAndMechanicList, transport.carsAndMechanicList) && Objects.equals(defaultMechanic, transport.defaultMechanic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, driver, carsAndMechanicList, defaultMechanic);
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

    public void printImportantInfo() {
        System.out.println("Transport is: " + getBrand() + " " + getModel() + " and its driver - " + getDriver().getFullName() + ". Mechanics team: " + getMechanicsList());
    }
}