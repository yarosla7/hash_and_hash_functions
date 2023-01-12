package driver;

public class LicenseB extends Driver {
    public LicenseB(String fullName) {
        super(fullName);
    }

    public LicenseB(String fullName, boolean hasDrivesLicense, double experienceYear) {
        super(fullName, hasDrivesLicense, experienceYear);
    }

    @Override
    public void toDrive() {
        super.toDrive();
    }

    @Override
    public void stopVehicle() {
        super.stopVehicle();
    }

    @Override
    public void refuelTheVehicle() {
        super.refuelTheVehicle();
    }

    @Override
    public String toString() {
        return "LicenseB{} " + super.toString();
    }
}
