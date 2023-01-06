import transport.Car;

public class Main {
    public static void main(String[] args) {

        Car lada = new Car("Lada", "Granta", 1.7, "black ", 2015, " ", false, "Sedan", 234, 4, false);
        lada.changeTiresForSeason();
        System.out.println("lada = " + lada);

        Car audi = new Car("Audi", "A8 50L TDI quattro", 3.0, "black", 2020, "Germany", true, "Hatchback", 4335, 4, true);
        audi.changeTiresForSeason();
        System.out.println("audi = " + audi);

        Car bmw = new Car("BMW", "Z8", 3.0, "black", 2021, "Germany", true, "Jeep", 4321, 4, false);
        bmw.changeTiresForSeason();
        System.out.println("bmw = " + bmw);

        Car kia = new Car("Kia", "Sportage 4th generation", 2.4, "red", 2018, "South Korea", true, "Coupe", 0, 4, false);
        kia.changeTiresForSeason();
        System.out.println("kia = " + kia);

        Car hyundai = new Car("Hyundai", "Avante", 1.6, "orange", 2016, "South Korea", true, "Wagon", 8767, 4, false);
        hyundai.changeTiresForSeason();
        System.out.println("hyundai = " + hyundai);

        Car myCar = new Car("", "", 0, "", -100, "", true, "", 0,0,true);
        myCar.changeTiresForSeason();
        System.out.println("emptyCar = " + myCar);
    }
}