package transport.stuff;
import transport.Transport;

import java.util.Arrays;
import java.util.Objects;

public class Mechanic<T extends Transport>  {

    private final String name;
    private final String company;

    public Mechanic(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public Mechanic(String name) {
        this.name = name;
        this.company = "Self employed";
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void performMaintenance(T transport) {
        System.out.println(getName() + " from " + getCompany() + " conducted maintenance. " + transport.getBrand() + " " + transport.getModel()+".");
    }

    @SafeVarargs
    public final void fixTheCar(T... transports) {
        System.out.println(getName() + " from " + getCompany() + " fixed the " + Arrays.toString(transports));
        System.out.println(Arrays.toString(transports) + " is fixed.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
