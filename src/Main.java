import transport.Car;

public class Main {
    public static void main(String[] args) {

        Car lada = new Car("Lada", "Granta", 1.7, "black ", 2015, " ", false, "Sedan", 234, 4, false, new Car.Key(false, true));
        lada.changeTiresForSeason();
        lada.setAutomaticTransmission(true);
        System.out.println("\nlada = " + lada);

        Car audi = new Car("Audi", "A8 50L TDI quattro", 3.0, "black", 2020, "Germany", true, "Hatchback", 4335, 4, true, new Car.Key(true, true));
        audi.changeTiresForSeason();
        System.out.println("\naudi = " + audi);

        Car bmw = new Car("BMW", "Z8", 3.0, "black", 2021, "Germany", true, "Jeep", 4321, 4, false, new Car.Key());
        bmw.changeTiresForSeason();
        System.out.println("\nbmw = " + bmw);

        Car kia = new Car("Kia", "Sportage 4th generation", 2.4, 2018);
        kia.changeTiresForSeason();
        System.out.println("\nkia = " + kia);

        Car hyundai = new Car("Hyundai", "Avante", 1.6, "orange", 2016, "South Korea", true, "Wagon", 8767, 4, false, new Car.Key(false, true));
        hyundai.changeTiresForSeason();
        System.out.println("\nhyundai = " + hyundai);

        Car myCar = new Car("", "", 0, "", -100, "", true, "", 0, 0, true, new Car.Key());
        myCar.changeTiresForSeason();
        System.out.println("\nemptyCar = " + myCar);
    }
}