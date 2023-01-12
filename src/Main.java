import transport.Bus;
import transport.Car;
import transport.Moto;

public class Main {
    public static void main(String[] args) {

        //cars

        Car lada = new Car("Lada", "Granta", 1.7, "black ", 2015, " ", false, "Sedan", 234, 4, false, 144, new Car.Key(false, true));
        lada.changeTiresForSeason();
        lada.setAutomaticTransmission(true);
        System.out.println("\nlada = " + lada);

        Car audi = new Car("Audi", "A8 50L TDI quattro", 3.0, "black", 2020, "Germany", true, "Hatchback", 4335, 4, true, 240, new Car.Key(true, true));
        audi.changeTiresForSeason();
        System.out.println("\naudi = " + audi);

        Car bmw = new Car("BMW", "Z8", 3.0, "black", 2021, "Germany", true, "Jeep", 4321, 4, false, 0, new Car.Key());
        bmw.changeTiresForSeason();
        System.out.println("\nbmw = " + bmw);

        Car kia = new Car("Kia", "Sportage 4th generation", 2018, "South Korea");
        kia.changeTiresForSeason();
        System.out.println("\nkia = " + kia);

        Car hyundai = new Car("Hyundai", "Avante", 1.6, "orange", 2016, "South Korea", true, "Wagon", 8767, 4, false, 244, new Car.Key(false, true));
        hyundai.changeTiresForSeason();
        System.out.println("\nhyundai = " + hyundai);

        Car myCar = new Car("", "", 0, "", -100, "", true, "", 0, 0, true, 0, new Car.Key());
        myCar.changeTiresForSeason();
        System.out.println("\nemptyCar = " + myCar);

        Car honda = new Car("Honda", "Civic", 2015, "");
        honda.changeTiresForSeason();
        System.out.println("\nhonda = " + honda);

        //buses

        Bus mercedes = new Bus("Mercedes", "", 1987, "Germany");
        System.out.println("\nmercedes = " + mercedes);
        Bus paz = new Bus("PAZ", "1983c", 1956, "USSR", "black", 86, 44, "Highway to Hell", true, true, 9_956);
        System.out.println("\npaz = " + paz);
        Bus randomBus = new Bus("", "", 0, "");
        System.out.println("\nrandomBus = " + randomBus);

        //moto

        Moto suzuki = new Moto("Suzuki", "a418", 2018, "Japan", "red", 364);
        System.out.println("\nsuzuki = " + suzuki);
        Moto randomMoto = new Moto("", "", 0, "");
        System.out.println("\nrandomMoto = " + randomMoto);

    }
}