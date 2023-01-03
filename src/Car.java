public class Car {
    String brand;
    String model;
    double engineVolume;
    String color;
    int year;
    String country;

    Car(String brand, String model, double engineVolume, String color, int year, String country) {

        if (brand.equals(" ") || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model.equals(" ") || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (color.equals(" ") || color.isBlank()) {
            this.color = "white";
        } else {
            this.color = color;
        }
        if (country.equals(" ") || country.isBlank()) {
            this.country = "default";
        } else {
            this.country = country;
        }
        if (engineVolume >= 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
        if (year >= 0) {
            this.year = year;
        } else {
            this.year = 2000;
        }
    }


    @Override
    public String toString() {
        return brand + " " + model + ", " + year + " — realise year, manufacturer country is " + country + ", body color is " + color + ", engine volume — " + engineVolume + " liters.";
    }
}
