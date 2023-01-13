package transport;

import driver.LicenseB;

public class Car extends Transport<LicenseB> { // разобрался, теперь всё правильно

    public Car(String brand, String model, double engineVolume, LicenseB driver) {
        super(brand, model, engineVolume, driver);
    }

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    } // Конструктор создан специально, если не указан водитель. На месте водителя так как не указано его имя будет null.

    @Override
    public String toString() {
        return "Car " + super.toString();
    }

    //Методы интерфейса в родительском классе. Так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.
}