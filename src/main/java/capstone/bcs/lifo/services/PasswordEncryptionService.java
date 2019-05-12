package capstone.bcs.lifo.services;

public interface PasswordEncryptionService {

    /**
     * Interface for the OrderDetailService
     * This is to follow best practices with regard to SOLID
     *
     */

    String encryptString(String input);
    boolean checkPassword(String textPassword, String encryptedPassword);
}
