package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car extends Transport {
    private static int countCars;
    private double engineVolume;
    private boolean isAutomaticTransmission;
    private final String bodyType;
    private int registrationNumber;
    private final int countOfSeats;
    private boolean isWinterTires;
    private Key key;

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int year,
               String country,
               boolean isAutomaticTransmission,
               String bodyType,
               int registrationNumber,
               int countOfSeats,
               boolean isWinterTires,
               int maxSpeed,
               Key key) {
        super(brand, model, year, country, color, maxSpeed);

        setEngineVolume(engineVolume);

        this.isAutomaticTransmission = isAutomaticTransmission;

        this.isWinterTires = isWinterTires;

        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) {
            this.bodyType = "default";
        } else if (bodyType.equals("Jeep") ||
                bodyType.equals("Hatchback") || bodyType.equals("Sedan") || bodyType.equals("Coupe") ||
                bodyType.equals("Wagon") || bodyType.equals("Van") || bodyType.equals("MUV/SUV") ||
                bodyType.equals("Convertible")) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = "default";
        }

        setRegistrationNumber(registrationNumber);

        if (countOfSeats <= 0) {
            this.countOfSeats = 4;
        } else {
            this.countOfSeats = countOfSeats;
        }

        this.key = Objects.requireNonNullElseGet(key, Key::new);

        countCars++;
    }

    public Car(String brand, String model, int year, String country) {
        this(brand, model,
                1.5,
                "white",
                year,
                country,
                false,
                "",
                0,
                4,
                false,
                0,
                new Key());
        countCars++;
    }

    public static int getCountCars() {
        return countCars;
    } //поле создано, чтобы заполнять этим число поле регистрационный номер, в случае его некорректного значения.

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        if (key == null) {
            key = new Key();
        } else {
            this.key = key;
        }
    }

    public String getBodyType() {
        return bodyType;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
    }

    public boolean isAutomaticTransmission() {
        return isAutomaticTransmission;
    }

    public void setAutomaticTransmission(boolean automaticTransmission) {
        isAutomaticTransmission = automaticTransmission;
    }

    public void setRegistrationNumber(int registrationNumber) {
        if (registrationNumber <= 0) {
            this.registrationNumber = countCars;
        } else {
            this.registrationNumber = registrationNumber;
        }
    }

    public void setWinterTires(boolean winterTires) {
        isWinterTires = winterTires;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public boolean isWinterTires() {
        return isWinterTires;
    }

    public int getMonth() {
        return LocalDate.now().getMonthValue();
    }

    public void changeTiresForSeason() {
        isWinterTires = getMonth() <= 3 || getMonth() == 12;
    } // оказывается и без if всё работает

    @Override
    public String toString() {
        return "\n" + getBrand() + " " + getModel() + ", " + getYear() + " — realise year, manufacturer country is " + getCountry() + ", body color is "
                + getColor() + ", engine volume — " + engineVolume + " liters. \n" + getMaxSpeed() + " km/h - max speed." +
                "\nTransmission: " + (isAutomaticTransmission ? "Automatic" : "Manual") + ", body type is " + bodyType +
                ", registration number - " + registrationNumber + ", seats: " + countOfSeats + "\nTires: "
                + (isWinterTires ? "Winter Tires." : "Summer Tires.") +
                "\nRemote Engine Start: " + (key.remoteEngineStart ? "Remote." : "Non-remote.") + "\nKeyless Access: " + (key.keylessAccess ? "Keyless." : "Non-keyless.");
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "remoteEngineStart=" + remoteEngineStart +
                    ", keylessAccess=" + keylessAccess +
                    '}';
        }
    } // По заданию был создан данный класс.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && isAutomaticTransmission == car.isAutomaticTransmission && registrationNumber == car.registrationNumber && countOfSeats == car.countOfSeats && isWinterTires == car.isWinterTires && Objects.equals(bodyType, car.bodyType) && Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineVolume, isAutomaticTransmission, bodyType, registrationNumber, countOfSeats, isWinterTires, key);
    }
}