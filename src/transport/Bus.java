package transport;

import java.util.Objects;

public class Bus extends Transport {
    private final boolean isIntercity;
    private int routeNumber;
    private String nameOfRoute;
    private boolean isOnRoute;
    private double mileage;

    public Bus(String brand, String model, int year, String country, String color, int maxSpeed, int routeNumber, String nameOfRoute, boolean isIntercity, boolean isOnRoute, double mileage) {
        super(brand, model, year, country, color, maxSpeed);
        setRouteNumber(routeNumber);
        this.isIntercity = isIntercity;
        setNameOfRoute(nameOfRoute);
        this.isOnRoute = isOnRoute;
        this.mileage = mileage;
    }

    public Bus(String brand, String model, int year, String country) {
        this(brand, model, year, country, "", 90, 0, "", false, false, 0.0);
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        if (routeNumber < 0) {
            this.routeNumber = Math.abs(routeNumber);
        } else {
            this.routeNumber = routeNumber;
        }
    }

    public boolean isIntercity() {
        return isIntercity;
    }

    public String getNameOfRoute() {
        return nameOfRoute;
    }

    public void setNameOfRoute(String nameOfRoute) {
        if (nameOfRoute == null || nameOfRoute.isBlank() || nameOfRoute.isEmpty() || routeNumber == 0) {
            this.nameOfRoute = "Route not assigned";
        } else {
            this.nameOfRoute = nameOfRoute;
        }
    }

    public boolean isOnRoute() {
        return isOnRoute;
    }

    public void setOnRoute(boolean onRoute) {
        isOnRoute = onRoute;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "\n" + getBrand() + " " + getModel() + ", " + getYear() + " — realise year, manufacturer country is " + getCountry() + ", body color is " + getColor() + ", mileage — " + (mileage == 0 ? "the new bus." : mileage) + " \n" + getMaxSpeed() + " km/h - max speed.\n" + "Route number is: " + routeNumber + ".\nRoute name is: " + nameOfRoute + ".\nNow on the route: " + (isOnRoute ? "Yes." : "In the parking lot.") + "\nIntercity: " + (isIntercity ? "Yes." : "No.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return isIntercity == bus.isIntercity && routeNumber == bus.routeNumber && isOnRoute == bus.isOnRoute && Double.compare(bus.mileage, mileage) == 0 && Objects.equals(nameOfRoute, bus.nameOfRoute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isIntercity, routeNumber, nameOfRoute, isOnRoute, mileage);
    }
}