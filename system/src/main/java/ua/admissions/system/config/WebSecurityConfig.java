package ua.admissions.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.admissions.system.security.CustomUserDetailsService;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig {


    @Autowired
    private UserDetailsService userDetailsService;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() {
        return new ProviderManager(Collections.singletonList(authenticationProvider()));
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").access("hasAuthority('APPLICANT') or hasAuthority('ADMIN')")
                .antMatchers("/examScores").access("hasAuthority('APPLICANT')")
                .antMatchers("/apply-admission").access("hasAuthority('APPLICANT')")                .antMatchers("/apply-admission").access("hasAuthority('APPLICANT')")
                .antMatchers("/applicantsByFaculty").access("hasAuthority('APPLICANT')")
                .antMatchers("/adminPage").access("hasAuthority('ADMIN')")
                .anyRequest().permitAll().and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home").usernameParameter("email").passwordParameter("password").and()
                .logout().logoutSuccessUrl("/login?logout").and()
                .exceptionHandling().accessDeniedPage("/403").and()
                .csrf().and().build();
    }
}
