package transport;

import driver.LicenseD;

public class Bus extends Transport<LicenseD> {
    private Capacity capacity;

    public Bus(String brand, String model, double engineVolume, LicenseD driver, Capacity capacity) {
        super(brand, model, engineVolume, driver);
        this.capacity = capacity;
    }

    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    } // Конструктор создан специально, если не указан водитель. Так как не указано его имя будет генерироваться ошибка

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public void printType() {
        if (capacity == null) {
            System.out.println("Bus data is not enough.");
        } else {
            System.out.println("Bus capacity: from " + capacity.getFrom() + " to " + capacity.getTo() + " people.");
        }
    }

    @Override
    public void passDiagnostics() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Busses can't pass diagnostics.");
    }

    @Override
    public String toString() {
        return "Bus " + super.toString();
    }

    // Методы интерфейса в родительском классе. Так как методы интерфейса по сути несут информацию общего характера для каждого объекта, переопределять методы под классы наследники не стал.

    public enum Capacity {
        EXTRA_SMALL(0, 10),
        SMALL(10, 25),
        MEDIUM(40, 50),
        LARGE(60, 80),
        EXTRA_LARGE(80, 120);
        private final int from;
        private final int to;

        Capacity(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }
}