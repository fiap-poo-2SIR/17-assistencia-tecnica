package br.fiap.assistencia_tecnica.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SenhaConfig {
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }
}
