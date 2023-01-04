public class Car {
    String brand;
    String model;
    double engineVolume;
    String color;
    int year;
    String country;

    Car(String brand, String model, double engineVolume, String color, int year, String country) {

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
    }


    @Override
    public String toString() {
        return brand + " " + model + ", " + year + " — realise year, manufacturer country is " + country + ", body color is " + color + ", engine volume — " + engineVolume + " liters.";
    }
}
