import transport.Bus;
import transport.Car;
import transport.Truck;

public class Main {
    public static void main(String[] args) {

        Bus paz = new Bus("ПАЗ", "4234", 4.3);
        Bus manBus = new Bus("MAN", "Lion's City", 5.6);
        Bus liaz = new Bus("ЛиАЗ", "4292", 4.4);
        Bus maz = new Bus("МАЗ", "232", 5.3);


        Car aston = new Car("Aston Martin", "DB9 Carbon", 3.6);
        Car audi = new Car("Audi", "S1 Quattro", 4.4);
        Car tesla = new Car("Tesla", "Model S", 3.2);
        Car mercedes = new Car("Mercedes", "Benz S-Class", 4.2);


        Truck kamaz = new Truck("КамАЗ", "54901", 7.6);
        Truck sollers = new Truck("Sollers", "Argo", 4.6);
        Truck dongfeng = new Truck("Dongfeng", "Captain-T", 5.5);
        Truck manTruck = new Truck("MAN", "TGS 6X6", 7.9);

        aston.startMoving();
        aston.maxSpeed();
        aston.bestLapTime();
        aston.crashed();

        paz.startMoving();
        paz.crashed();

        kamaz.startMoving();
        kamaz.pitStop();
        kamaz.crashed();
    }
}