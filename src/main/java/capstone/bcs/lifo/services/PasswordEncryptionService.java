package capstone.bcs.lifo.services;

public interface PasswordEncryptionService {

    String encryptString(String input);
    boolean checkPassword(String textPassword, String encryptedPassword);
}
