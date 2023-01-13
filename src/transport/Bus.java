package transport;

import driver.LicenseD;

public class Bus extends Transport<LicenseD> {

    public Bus(String brand, String model, double engineVolume, LicenseD driver) {
        super(brand, model, engineVolume, driver);
    }

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    } // Конструктор создан специально, если не указан водитель. Так как не указано его имя будет генерироваться ошибка

    @Override
    public String toString() {
        return "Bus " + super.toString();
    }

    // Методы интерфейса в родительском классе. Так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.

}