package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private static int countCars;
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
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
               boolean isWinterTires, Key key) {

        if (brand == null || brand.isBlank() || brand.isEmpty()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isBlank() || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (color == null || color.isBlank() || color.isEmpty()) {
            this.color = "white";
        } else {
            this.color = color;
        }
        if (country == null || country.isBlank() || country.isEmpty()) {
            this.country = "default";
        } else {
            this.country = country;
        }
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
        if (year >= 0) {
            this.year = year;
        } else {
            this.year = 2000;
        }

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
        if (registrationNumber <= 0) {
            this.registrationNumber = countCars;
        } else {
            this.registrationNumber = registrationNumber;
        }
        if (countOfSeats <= 0) {
            this.countOfSeats = 4;
        } else {
            this.countOfSeats = countOfSeats;
        }
        this.key = Objects.requireNonNullElseGet(key, Key::new);
        countCars++;
    }

    public Car(String brand, String model, double engineVolume, int year) {
        this(brand,
                model,
                engineVolume,
                null,
                year,
                null,
                false,
                null,
                0,
                0,
                false,
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
        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) {
            return "default";
        } else if (bodyType.equals("Jeep") ||
                bodyType.equals("Hatchback") || bodyType.equals("Sedan") || bodyType.equals("Coupe") ||
                bodyType.equals("Wagon") || bodyType.equals("Van") || bodyType.equals("MUV/SUV") ||
                bodyType.equals("Convertible")) {
            return bodyType;
        } else {
            return "default";
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
    }

    public void setColor(String color) {
        if (color == null || color.isBlank() || color.isEmpty()) {
            this.color = "white";
        } else {
            this.color = color;
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
        return "\n" + brand + " " + model + ", " + year + " — realise year, manufacturer country is " + country + ", body color is "
                + color + ", engine volume — " + engineVolume + " liters." +
                "\nTransmission: " + (isAutomaticTransmission ? "Automatic" : "Manual") + ", body type is " + bodyType + ", registration number - " + registrationNumber + ", seats: " + countOfSeats + "\nTires: " + (isWinterTires ? "Winter Tires." : "Summer Tires.") +
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
}
