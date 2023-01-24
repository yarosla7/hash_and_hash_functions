package driver;

public class CheckLicenseException extends Exception {

    public CheckLicenseException(String message) {
        super(message);
    }

} // так как наш код не позволяет создать водителя с некооректным типом лицензии проверка будет только на наличие прав.

