package transport;

import driver.LicenseC;

public class Truck extends Transport<LicenseC> {

    public Truck(String brand, String model, double engineVolume, LicenseC driver) {
        super(brand, model, engineVolume, driver);
    }

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    } // Конструктор создан специально, если не указан водитель. На месте водителя так как не указано его имя будет генерироваться ошибка

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }


    //методы интерфейса в родительском классе. так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.
}