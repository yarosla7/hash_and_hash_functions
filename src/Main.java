import driver.CheckLicenseException;
import driver.LicenseB;
import driver.LicenseC;
import driver.LicenseD;
import transport.Bus;
import transport.Car;
import transport.Truck;

public class Main {
    public static void main(String[] args) throws CheckLicenseException {

        Bus paz = new Bus("ПАЗ", "4234", 4.3, new LicenseD("Dilan", true, 6), Bus.Capacity.SMALL);
        Bus manBus = new Bus("MAN", "Lion's City", 5.6, new LicenseD("Fagot"), Bus.Capacity.LARGE);
        Bus liaz = new Bus("ЛиАЗ", "4292", 4.4, Bus.Capacity.EXTRA_LARGE);
        Bus maz = new Bus("МАЗ", "232", 5.3, Bus.Capacity.MEDIUM);


        Car aston = new Car("Aston Martin", "DB9 Carbon", 3.6, new LicenseB("Mike", true, 3), Car.BodyType.SEDAN);
        Car audi = new Car("Audi", "S1 Quattro", 4.4, Car.BodyType.CROSSOVER);
        Car tesla = new Car("Tesla", "Model S", 3.2, new LicenseB("Alex", true, 2), Car.BodyType.SEDAN);
        Car mercedes = new Car("Mercedes", "Benz S-Class", 4.2, Car.BodyType.HATCHBACK);


        Truck kamaz = new Truck("КамАЗ", "54901", 7.6, new LicenseC("John", true, 4), Truck.Weight.N2);
        Truck sollers = new Truck("Sollers", "Argo", 4.6, Truck.Weight.N3);
        Truck dongfeng = new Truck("Dongfeng", "Captain-T", 5.5, Truck.Weight.N1);
        Truck manTruck = new Truck("MAN", "TGS 6X6", 7.9, new LicenseC("Dick", true, 4), Truck.Weight.N3);

        LicenseD morgan = new LicenseD("Morgan", true, 5);
        LicenseD dilan = new LicenseD("Dilan", true, 6);
        LicenseB logan = new LicenseB("Logan", true, 1);
        LicenseB nik = new LicenseB("Nikita", true, 1);
//testing:
 /*       aston.startMoving();
        aston.maxSpeed();
        aston.bestLapTime();
        aston.crashed();

        paz.startMoving();
        paz.crashed();

        kamaz.startMoving();
        kamaz.pitStop();
        kamaz.crashed();

        kamaz.willParticipate(kamaz.getDriver());
        aston.willParticipate(aston.getDriver());
        tesla.willParticipate(tesla.getDriver());
        manTruck.willParticipate(manTruck.getDriver());
        paz.willParticipate(dilan);
        paz.willParticipate(paz.getDriver());
        liaz.willParticipate(dilan);
        manBus.willParticipate(morgan);*/
        //exceptions:

        try {
            aston.passDiagnostics();
            tesla.passDiagnostics();
            kamaz.passDiagnostics();
            manBus.passDiagnostics();
        } catch (CheckLicenseException | UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Diagnostic is complete.");
        }
    }
}