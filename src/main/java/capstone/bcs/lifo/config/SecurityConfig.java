package capstone.bcs.lifo.config;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@Configuration
@EnableJpaRepositories("capstone.bcs.lifo.repositories")
public class SecurityConfig // extends WebSecurityConfigurerAdapter{
{
    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor(){
        StrongPasswordEncryptor passwordEncryptorencryptor = new StrongPasswordEncryptor();
        return passwordEncryptorencryptor;
    }


    // this is needed or you can't access the site, there will be another login that blocks pages
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//    }

}
