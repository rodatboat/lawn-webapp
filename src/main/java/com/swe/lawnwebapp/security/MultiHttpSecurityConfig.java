package com.swe.lawnwebapp.security;

import com.swe.lawnwebapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Configuration
    public static class AdminSecurity extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()

                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/agent").hasAnyRole("AGENT", "ADMIN")
                    .antMatchers("/user").hasAnyRole("USER", "ADMIN")

                    .antMatchers("/",
                            "/properties/**",
                            "/agents/**",
                            "/assets/**",
                            "/register/**",
//                            "/register",
                            "/login").permitAll()
                    .anyRequest().authenticated()

                    .and().logout().logoutSuccessUrl("/index.html").permitAll()

                    .and()
                    .formLogin();
        }
        //.antMatchers("/user/**").hasRole("USER")
        //.antMatchers("/agents/**").hasAnyRole("ADMIN","USER")
        //.antMatchers("/**").anonymous()
        //.anyRequest().authenticated()
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();

        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
    }
}
