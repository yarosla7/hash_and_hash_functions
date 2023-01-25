package transport;

import driver.CheckLicenseException;
import transport.stuff.Mechanic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServiceStation<T extends  Transport<?>> {

    private final Queue<T> tQueue = new LinkedList<>();

    public ServiceStation() {
    }

    public void addTransport(T auto) {
        tQueue.offer(auto);
    }
    Mechanic<?> a = new Mechanic<>("Dilshod");

    public void doServiceInspection() throws UnsupportedOperationException, CheckLicenseException {
        T auto = gettQueue().poll();
//        assert auto != null;
        if (auto != null) {
            auto.passDiagnostics(); // провеерка не являяется ли объект автобусом, так как им не нужен техосмотр
            auto.addDefMec(a); // на всякий добавляем дефолтного механика, если он не добавлен к автомобилю в мейне
            for (String s : Arrays.asList(auto.getMechanicsList() + " " + auto.getDefaultMechanic() + " carry out a technical inspection of the car " + auto.getModel() + " " + auto.getBrand(), auto.getBrand() + " " + auto.getModel() + " completed diagnostics.")) {
                System.out.println(s);
            }
            doServiceInspection();
        } else {
            System.out.println("No cars found.");
        }
    }

    public Queue<T> gettQueue() {
        return tQueue;
    }
}
