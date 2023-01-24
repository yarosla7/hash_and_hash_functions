package transport;

import driver.CheckLicenseException;
import driver.LicenseB;

public class Car extends Transport<LicenseB> {
    private BodyType bodyType;

    public Car(String brand, String model, double engineVolume, LicenseB driver, BodyType bodyType) {
        super(brand, model, engineVolume, driver);
        this.bodyType = bodyType;
    }


    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    } // Конструктор создан специально, если не указан водитель. На месте водителя так как не указано его имя будет null.

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }

    @Override
    public void printType() {
        if (bodyType == null) {
            System.out.println("Not enough car data.");
        } else {
            System.out.println("Body type of car: " + bodyType.getBodyType());
        }
    }

    @Override
    public void passDiagnostics() throws CheckLicenseException {
        if (!getDriver().isHasDrivesLicense()) {
            throw new CheckLicenseException("License from " + getDriver().getFullName() + " : 404 not found.");
        } else {
            System.out.println(getBrand() + " " + getModel() + " undergoes diagnostics.");
            System.out.println(getBrand() + " " + getModel() + " completed diagnostics.");
        }
    }

    //Методы интерфейса в родительском классе. Так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.
    public enum BodyType {
        SEDAN("Sedan"),
        HATCHBACK("Hatchback"),
        COUPE("Coupe"),
        UNIVERSAL("Universal"),
        SUV("Off-road"),
        CROSSOVER("Crossover"),
        PICKUP("Pickup"),
        VAN("Van"),
        MINIVAN("Minivan");

        private final String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }
    }
}