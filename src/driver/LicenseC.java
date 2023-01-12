package driver;

public class LicenseC extends Driver {
    public LicenseC(String fullName) {
        super(fullName);
    }

    public LicenseC(String fullName, boolean hasDrivesLicense, double experienceYear) {
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
        return "LicenseC{} " + super.toString();
    }
}