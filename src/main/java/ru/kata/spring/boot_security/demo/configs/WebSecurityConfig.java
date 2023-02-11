package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SuccessUserHandler successUserHandler;

    public WebSecurityConfig(SuccessUserHandler successUserHandler) {
        this.successUserHandler = successUserHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**")
                .hasRole("USER")   //на страницу юзера можно впускать админа, только если у него есть роль юзер.
                .antMatchers("/login").permitAll()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/process_login")
                .successHandler(successUserHandler)
                .failureUrl("/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}