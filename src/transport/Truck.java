package transport;

import driver.CheckLicenseException;
import driver.LicenseC;

public class Truck extends Transport<LicenseC> {
    private Weight weight;

    public Truck(String brand, String model, double engineVolume, LicenseC driver, Weight weight) {
        super(brand, model, engineVolume, driver);
        this.weight = weight;
    }

    public Truck(String brand, String model, double engineVolume, Weight weight) {
        super(brand, model, engineVolume);
        this.weight = weight;
    } // Конструктор создан специально, если не указан водитель. На месте водителя так как не указано его имя будет генерироваться ошибка

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public void printType() {
        if (weight == null) {
            System.out.println("Truck data is not enough.");
        } else {
            String from = weight.getFrom() == null ? "" : "from " + weight.getFrom() + " ";
            String to = weight.getTo() == null ? "" : "to " + weight.getFrom();
            System.out.println("Truck load weight:" + from + to + " tons.");
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

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }

    public enum Weight {
        N1(0D, 3.5),
        N2(3.5, 12D),
        N3(12D, null);

        private final Double from;
        private final Double to;

        Weight(Double from, Double to) {
            this.from = from;
            this.to = to;
        }

        public Double getFrom() {
            return from;
        }

        public Double getTo() {
            return to;
        }

        @Override
        public String toString() {
            return "Weight{" +
                    "from=" + from +
                    ", to=" + to +
                    "} " + super.toString();
        }
    }
    //методы интерфейса в родительском классе. так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.
}