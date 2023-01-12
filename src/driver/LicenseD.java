package driver;

public class LicenseD extends Driver {
    public LicenseD(String fullName) {
        super(fullName);
    }

    public LicenseD(String fullName, boolean hasDrivesLicense, double experienceYear) {
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
        return "LicenseD{} " + super.toString();
    }
}
