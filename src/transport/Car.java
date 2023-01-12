package transport;

import driver.LicenseB;

public class Car extends Transport<LicenseB> { // разобрался, теперь всё правильно

    public Car(String brand, String model, double engineVolume, LicenseB driver) {
        super(brand, model, engineVolume, driver);
    }

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    } // Конструктор создан специально, если не указан водитель. На месте водителя так как не указано его имя будет null.

    //методы родительского класса:

    @Override
    public void startMoving() {
        getDriver().toDrive();
        System.out.println(getBrand() + " " + getModel() + " started moving.");
        System.out.println(getBrand() + " is moving right now.");
    }

    @Override
    public void endMoving() {
        getDriver().stopVehicle();
        System.out.println(getBrand() + " " + getModel() + " slows down.");
        System.out.println(getBrand() + " " + getModel() + "  has stopped.");
    } // Теперь без водителя не выйдет поехать. Ура.

    @Override
    public String toString() {
        return "Car " + super.toString();
    }

    //Методы интерфейса в родительском классе. Так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.

    //методы водителя для взаимодействия с автомобилем:

    public void willParticipate(LicenseB driver) {

        if (driver.isHasDrivesLicense()) {
            System.out.println("Driver " + driver.getFullName() + " drives " + this + " and will participate in the race.");
        } else {
            System.out.println("Driver " + driver.getFullName() + " excluded.");
        }
    }
}