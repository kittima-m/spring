package web.spring.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.ignoringRequestMatchers("/saveMsg"));
        http.authorizeHttpRequests((requests) -> {
            requests.requestMatchers("/dashboard").authenticated();
            requests.requestMatchers("/login").permitAll();
            requests.requestMatchers("/logout").permitAll();
            requests.requestMatchers("/","/home").permitAll();
            requests.requestMatchers("/courses").permitAll();
            requests.requestMatchers("/about").permitAll();
            requests.requestMatchers("/contact").permitAll();
            requests.requestMatchers("/holidays/**").permitAll();
            requests.requestMatchers("/assets/**").permitAll();
            requests.requestMatchers("/error").permitAll();
        });
        http.formLogin((formLogin) -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true")
                .permitAll()
        );

        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("12345").roles("USER", "ADMIN").build();
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("12345").roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
    }
}
