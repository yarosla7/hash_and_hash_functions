import driver.LicenseB;
import driver.LicenseC;
import driver.LicenseD;
import transport.Bus;
import transport.Car;
import transport.Truck;

public class Main {
    public static void main(String[] args) {

        Bus paz = new Bus("ПАЗ", "4234", 4.3, new LicenseD("Dilan", true, 6));
        Bus manBus = new Bus("MAN", "Lion's City", 5.6, new LicenseD("Fagot"));
        Bus liaz = new Bus("ЛиАЗ", "4292", 4.4);
        Bus maz = new Bus("МАЗ", "232", 5.3);


        Car aston = new Car("Aston Martin", "DB9 Carbon", 3.6, new LicenseB("Mike", true, 3));
        Car audi = new Car("Audi", "S1 Quattro", 4.4);
        Car tesla = new Car("Tesla", "Model S", 3.2, new LicenseB("Alex", true, 2));
        Car mercedes = new Car("Mercedes", "Benz S-Class", 4.2);


        Truck kamaz = new Truck("КамАЗ", "54901", 7.6, new LicenseC("John", true, 4));
        Truck sollers = new Truck("Sollers", "Argo", 4.6);
        Truck dongfeng = new Truck("Dongfeng", "Captain-T", 5.5);
        Truck manTruck = new Truck("MAN", "TGS 6X6", 7.9, new LicenseC("Dick", true, 4));
//testing:
        aston.startMoving();
        aston.maxSpeed();
        aston.bestLapTime();
        aston.crashed();

        paz.startMoving();
        paz.crashed();

        kamaz.startMoving();
        kamaz.pitStop();
        kamaz.crashed();
//============================================
        LicenseD morgan = new LicenseD("Morgan", true, 5);
        LicenseD dilan = new LicenseD("Dilan", true, 6);
        LicenseB logan = new LicenseB("Logan");

        kamaz.willParticipate(kamaz.getDriver());
        aston.willParticipate(aston.getDriver());
        tesla.willParticipate(tesla.getDriver());
        manTruck.willParticipate(manTruck.getDriver());
        paz.willParticipate(dilan);
        paz.willParticipate(paz.getDriver());
        liaz.willParticipate(dilan); // проверка, что один и тот же водитель (Дилан) может быть создан и через конструктор транспорта
        // так и отдельно, и пересесть в другой транспорт, если проинициализирован отдельно как объект
        manBus.willParticipate(morgan);
        audi.willParticipate(logan);
        //System.out.println("sollers.getDriver() = " + sollers.getDriver());//проверка на ошибку если хотят посмотреть водителя машины,
        // где водитель не создан (не введено хотя бы имя)

        mercedes.startMoving(); // и тут тоже ошибка! Машины теперь не ездят без водителей, ура.

    }
}
// Вот, что в консоли:

//        Mike started the engine, pressed the pedal and drove.
//        Aston Martin DB9 Carbon started moving.
//        Aston Martin is moving right now.

//        Car Aston Martin , model: DB9 Carbon , engineVolume: 3.6 has maximal speed. Mike looks like a winner.
//        Car Aston Martin , model: DB9 Carbon , engineVolume: 3.6 has best time lap.
//        Car Aston Martin , model: DB9 Carbon , engineVolume: 3.6 has been crashed. Mike is dead. Game over.

//        Dilan started the engine, pressed the pedal and drove.
//        ПАЗ 4234 started the engine and started moving on a route with all stops.
//        ПАЗ is moving right now.
//        Bus ПАЗ , model: 4234 , engineVolume: 4.3 has been crashed. Dilan is dead. Game over.

//        John started the engine, pressed the pedal and drove.
//        КамАЗ 54901 started the engine and started moving on a route.
//        КамАЗ is moving right now.
//        Truck КамАЗ , model: 54901 , engineVolume: 7.6 went to the pit-stop.John is smoking right now.
//        Truck КамАЗ , model: 54901 , engineVolume: 7.6 has been crashed. John is dead. Game over.


//        Driver John drives Truck КамАЗ , model: 54901 , engineVolume: 7.6 and will participate in the race.

//        Driver Mike drives Car Aston Martin , model: DB9 Carbon , engineVolume: 3.6 and will participate in the race.

//        Driver Alex drives Car Tesla , model: Model S , engineVolume: 3.2 and will participate in the race.

//        Driver Dick drives Truck MAN , model: TGS 6X6 , engineVolume: 7.9 and will participate in the race.

//        Driver Dilan drives Bus ПАЗ , model: 4234 , engineVolume: 4.3 and will participate in the race.

//        Driver Dilan drives Bus ПАЗ , model: 4234 , engineVolume: 4.3 and will participate in the race.

//        Driver Dilan drives Bus ЛиАЗ , model: 4292 , engineVolume: 4.4 and will participate in the race.

//        Driver Morgan drives Bus MAN , model: Lion's City , engineVolume: 5.6 and will participate in the race.

//        Driver Logan excluded.

//        Exception in thread "main" java.lang.RuntimeException: Driver is not createdCar Mercedes , model: Benz S-Class , engineVolume: 4.2 is empty.

//        at transport.Transport.getDriver(Transport.java:49)
//        at transport.Car.startMoving(Car.java:19)
//        at Main.main(Main.java:57)
//
//        Process finished with exit code 1