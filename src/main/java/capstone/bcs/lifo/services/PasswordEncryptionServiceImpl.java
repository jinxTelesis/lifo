package capstone.bcs.lifo.services;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;


@Service
public class PasswordEncryptionServiceImpl implements PasswordEncryptionService {

    /**
     * the encryption service is third party, this just uses what was provided
     * by the SecurityConfig class in the configuration package.
     */

    private StrongPasswordEncryptor strongPasswordEncryptor;

    PasswordEncryptionServiceImpl(StrongPasswordEncryptor strongPasswordEncryptor) {
        this.strongPasswordEncryptor = strongPasswordEncryptor;
    }

    @Override
    public String encryptString(String input) {
        return strongPasswordEncryptor.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String textPassword, String encryptedPassword) {
        return strongPasswordEncryptor.checkPassword(textPassword,encryptedPassword);
    }
}
