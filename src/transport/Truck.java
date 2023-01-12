package transport;

import driver.LicenseC;

public class Truck extends Transport<LicenseC> {

    public Truck(String brand, String model, double engineVolume, LicenseC driver) {
        super(brand, model, engineVolume, driver);
    }

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    } // Конструктор создан специально, если не указан водитель. На месте водителя так как не указано его имя будет генерироваться ошибка


    //методы родительского класса:

    @Override
    public void startMoving() {
        getDriver().toDrive();
        System.out.println(getBrand() + " " + getModel() + " started the engine and started moving on a route.");
        System.out.println(getBrand() + " is moving right now.");
    }

    @Override
    public void endMoving() {
        getDriver().stopVehicle();
        System.out.println(getBrand() + " " + getModel() + " slows down.");
        System.out.println(getBrand() + " " + getModel() + " has stopped.");
    }

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }


    //методы интерфейса в родительском классе. так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.

    //методы водителя для взаимодействия с автомобилем:

    public void willParticipate(LicenseC driver) {
        if (driver.isHasDrivesLicense()) {
            System.out.println("Driver " + driver.getFullName() + " drives " + this + " and will participate in the race.");
        } else {
            System.out.println("Driver " + driver.getFullName() + " excluded.");
        }
    }
}