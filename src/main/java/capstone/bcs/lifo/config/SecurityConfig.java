package capstone.bcs.lifo.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories("capstone.bcs.lifo.repositories")
public class SecurityConfig {

    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor(){
        StrongPasswordEncryptor passwordEncryptorencryptor = new StrongPasswordEncryptor();
        return passwordEncryptorencryptor;
    }

}
