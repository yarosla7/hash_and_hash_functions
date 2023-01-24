package driver;

public class LicenseD extends Driver {
    public LicenseD(String fullName) {
        super(fullName);
    }

    public LicenseD(String fullName, boolean hasDrivesLicense, double experienceYear) throws CheckLicenseException {
        super(fullName, hasDrivesLicense, experienceYear);
    }

    @Override
    public String toString() {
        return "LicenseD{} " + super.toString();
    }
}