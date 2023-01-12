package transport;

public abstract class Transport {

    private final String brand;
    private final String model;
    private double engineVolume;

    public Transport(String brand, String model, int engineVolume) {
        this.brand = brand;
        this.model = model;
        this.engineVolume = engineVolume;
    }

    public String getBrand() {

        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void startMoving() {
        System.out.println("Driving");
    }

    public void endMoving() {
        System.out.println("Stopped");
    }
}