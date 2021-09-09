package com.swe.lawnwebapp.security;

import com.swe.lawnwebapp.repositories.UserRepository;
import com.swe.lawnwebapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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

//                    .antMatchers("/**").hasAnyRole("ADMIN")

                    .antMatchers("/",
                            "/properties/*",
                            "/agents/*",
                            "/about/*",
                            "/register/*")
                        .permitAll()
                    .and()
                    .formLogin();
        }

        //.antMatchers("/agents/**").hasAnyRole("ADMIN","USER")
        //.antMatchers("/**").anonymous()
        //.anyRequest().authenticated()
    }

//    @Configuration
//    @Order(2)
//    public static class AgentSecurity extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/api/v*/registration/**").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin();
//        }
//
//        //.antMatchers("/agents/**").hasAnyRole("ADMIN","USER")
//        //.antMatchers("/**").anonymous()
//    }
//
//    @Configuration
//    @Order(3)
//    public static class UserSecurity extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/api/v*/registration/**").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin();
//        }
//
//        //.antMatchers("/agents/**").hasAnyRole("ADMIN","USER")
//        //.antMatchers("/**").anonymous()
//    }

//    @Configuration
//    @Order(4)
//    public static class GuestSecurity extends WebSecurityConfigurerAdapter{
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .csrf().disable()
//                    .authorizeRequests()
//                    .antMatchers("/","/properties/*","/agents/*").permitAll();
//        }
//
//        //.antMatchers("/agents/**").hasAnyRole("ADMIN","USER")
//        //.antMatchers("/**").anonymous()
//    }

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
