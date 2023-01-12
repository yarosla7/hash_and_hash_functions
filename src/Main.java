import driver.LicenseB;
import driver.LicenseC;
import driver.LicenseD;
import transport.Bus;
import transport.Car;
import transport.Truck;

public class Main {
    public static void main(String[] args) {

        Bus<driver.LicenseD> paz = new Bus<>("ПАЗ", "4234", 4.3);
        Bus<driver.LicenseD> manBus = new Bus<>("MAN", "Lion's City", 5.6);
        Bus<driver.LicenseD> liaz = new Bus<>("ЛиАЗ", "4292", 4.4);
        Bus<driver.LicenseD> maz = new Bus<>("МАЗ", "232", 5.3);


        Car<LicenseB> aston = new Car<>("Aston Martin", "DB9 Carbon", 3.6);
        Car<LicenseB> audi = new Car<>("Audi", "S1 Quattro", 4.4);
        Car<LicenseB> tesla = new Car<>("Tesla", "Model S", 3.2);
        Car<LicenseB> mercedes = new Car<>("Mercedes", "Benz S-Class", 4.2);


        Truck<LicenseC> kamaz = new Truck<>("КамАЗ", "54901", 7.6);
        Truck<LicenseC> sollers = new Truck<>("Sollers", "Argo", 4.6);
        Truck<LicenseC> dongfeng = new Truck<>("Dongfeng", "Captain-T", 5.5);
        Truck<LicenseC> manTruck = new Truck<>("MAN", "TGS 6X6", 7.9);

//        aston.startMoving();
//        aston.maxSpeed();
//        aston.bestLapTime();
//        aston.crashed();
//
//        paz.startMoving();
//        paz.crashed();
//
//        kamaz.startMoving();
//        kamaz.pitStop();
//        kamaz.crashed();

        LicenseB mike = new LicenseB("Mike", true, 3);
        aston.willParticipate(mike);
        LicenseB alex = new LicenseB("Alex", true, 2);
        tesla.willParticipate(alex);
        LicenseC dick = new LicenseC("Dick", true, 4);
        manTruck.willParticipate(dick);
        LicenseC john = new LicenseC("John", true, 4);
        kamaz.willParticipate(john);
        LicenseD dilan = new LicenseD("Dilan", true, 6);
        paz.willParticipate(dilan);
        LicenseD morgan = new LicenseD("Morgan", true, 5);
        manBus.willParticipate(morgan);
        LicenseB logan = new LicenseB("Logan");
        audi.willParticipate(logan);
    }
}