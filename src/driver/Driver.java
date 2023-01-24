package driver;

import java.util.Objects;

public abstract class Driver {

    private final String fullName; // Да, fullName, но в дальнейшем мне будет лень писать ФИО. Так что удовлетворяя задаче пишу фулнейм, по факту нейм.
    private boolean hasDrivesLicense;
    private double experienceYear;

    public Driver(String fullName) {
        if (fullName == null || fullName.isEmpty() || fullName.isBlank()) {
            throw new RuntimeException("Enter full name to create a driver"); //если поле имени пустое невозможно создать объект
        } else {
            this.fullName = fullName;
        }
        this.hasDrivesLicense = false;
        this.experienceYear = 0.0;
    }

    public Driver(String fullName, boolean hasDrivesLicense, double experienceYear) throws CheckLicenseException {
        this(fullName);
        this.hasDrivesLicense = hasDrivesLicense;
        setExperienceYear(experienceYear);
    }

    public Driver() {
        this.fullName = null;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isHasDrivesLicense() {
        return hasDrivesLicense;
    }

    public void setHasDrivesLicense(boolean hasDrivesLicense) {
        this.hasDrivesLicense = hasDrivesLicense;
    }

    public double getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(double experienceYear) {

        if (isHasDrivesLicense()) {
            this.experienceYear = experienceYear;
        } else {
            System.out.println(getFullName() + " have no license = no license no experience");
        }
    }

    //методы водителей:

    public void toDrive() throws CheckLicenseException {
        if (isHasDrivesLicense() || getExperienceYear() >= 0.1) {
            System.out.println(getFullName() + " started the engine, pressed the pedal and drove.");
        } else {
            System.out.println("No license = no drive.");
        }
    }

    public void stopVehicle() throws CheckLicenseException {
        if (!isHasDrivesLicense() && getExperienceYear() == 0.0) {
            throw new RuntimeException("Nothing to stop");
        } else {
            System.out.println(getFullName() + " has stopped vehicle");
        }
    }

    public void refuelTheVehicle() throws CheckLicenseException {
        if (!isHasDrivesLicense() && getExperienceYear() <= 0.0) {
            throw new RuntimeException("Nothing to refuel");
        } else {
            System.out.println(getFullName() + " has refuel vehicle");
        }
    }

    @Override
    public String toString() {
        return "Driver{" +
                "fullName='" + fullName + '\'' +
                ", hasDrivesLicense=" + hasDrivesLicense +
                ", experienceYear=" + experienceYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return hasDrivesLicense == driver.hasDrivesLicense && Double.compare(driver.experienceYear, experienceYear) == 0 && Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, hasDrivesLicense, experienceYear);
    }
}