import transport.Car;

public class Main {
    public static void main(String[] args) {

        Car lada = new Car("Lada", "Granta", 1.7, "black ", 2015, " ",
                false, "Sedan", 234, 4, false);
        lada.changeTiresForSeason();
        Car.Key ladaKey = lada.new Key(false, false);
        lada.setKey(ladaKey);
        System.out.println("\nlada = " + lada);

        Car audi = new Car("Audi", "A8 50L TDI quattro", 3.0, "black", 2020, "Germany", true, "Hatchback", 4335, 4, true);
        audi.changeTiresForSeason();
        Car.Key audiKey = audi.new Key(true, true);
        audi.setKey(audiKey);
        System.out.println("\naudi = " + audi);

        Car bmw = new Car("BMW", "Z8", 3.0, "black", 2021, "Germany", true, "Jeep", 4321, 4, false);
        bmw.changeTiresForSeason();
        Car.Key bmwKey = bmw.new Key(true, true);
        bmw.setKey(bmwKey);
        System.out.println("\nbmw = " + bmw);

        Car kia = new Car("Kia", "Sportage 4th generation", 2.4, "red", 2018, "South Korea", true, "Coupe", 0, 4, false);
        kia.changeTiresForSeason();
        Car.Key kiaKey = kia.new Key(true, true);
        kia.setKey(kiaKey);
        System.out.println("\nkia = " + kia);

        Car hyundai = new Car("Hyundai", "Avante", 1.6, "orange", 2016, "South Korea", true, "Wagon", 8767, 4, false);
        hyundai.changeTiresForSeason();
        Car.Key hyundaiKey = hyundai.new Key(true, false);
        hyundai.setKey(hyundaiKey);
        System.out.println("\nhyundai = " + hyundai);

        Car myCar = new Car("", "", 0, "", -100, "", true, "", 0, 0, true);
        myCar.changeTiresForSeason();
        Car.Key myCarKey = myCar.new Key(false, true);
        myCar.setKey(myCarKey);
        System.out.println("\nemptyCar = " + myCar);
    }
}