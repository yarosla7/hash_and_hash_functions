package driver;

public class LicenseB extends Driver {
    public LicenseB(String fullName) {
        super(fullName);
    }

    public LicenseB(String fullName, boolean hasDrivesLicense, double experienceYear) throws CheckLicenseException {
        super(fullName, hasDrivesLicense, experienceYear);
    }

    @Override
    public void toDrive() throws CheckLicenseException {
        if (isHasDrivesLicense() || getExperienceYear() >= 0.1) {
            System.out.println(getFullName() + " seat in a car(!), started the engine, pressed the pedal and drove.");
        } else {
            System.out.println("No license B = no drive.");
        }
    }

    public void stopVehicle() throws CheckLicenseException {
        if (!isHasDrivesLicense() && getExperienceYear() == 0.0) {
            throw new RuntimeException("Nothing to stop");
        } else {
            System.out.println(getFullName() + " has stopped a car");
        }
    }

    public void refuelTheVehicle() throws CheckLicenseException {
        if (!isHasDrivesLicense() && getExperienceYear() <= 0.0) {
            throw new RuntimeException("Nothing to refuel");
        } else {
            System.out.println(getFullName() + " has refuel car");
        }
    } // переопределил методы из класса Driver (но только для категории Б)

    @Override
    public String toString() {
        return "LicenseB{} " + super.toString();
    }
}