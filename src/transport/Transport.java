package transport;

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
            throw new RuntimeException("Driver is not created" + this + " is empty.");
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

    public abstract void startMoving();

    /**
     * можно как-то написать тут блок кода, чтобы наследовать данный метод не изменяя?
     */

    public abstract void endMoving();

    /**
     * можно как-то написать тут блок кода, чтобы наследовать данный метод не изменяя?
     */

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
    public void willParticipate(D driver) {

    } /** можно как-то написать тут блок кода, чтобы наследовать данный метод не изменяя?*/
}