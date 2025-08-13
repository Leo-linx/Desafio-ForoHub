package alura.forohub.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth

                        // Permitir login sin autenticación previa
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()

                        // Permite acceso público a todos los endpoints de tópicos
                        .requestMatchers(HttpMethod.GET, "/topicos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/topicos/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/topicos").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/topicos/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/topicos/**").permitAll()
                        // Requiere autenticación para otros endpoints
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}