package com.project.bookstore.service;

import javax.sql.DataSource;

import com.project.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    private UserRepository repo;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
////                .antMatchers("/login").permitAll()
//                .antMatchers("/adminPage").hasAuthority("ADMIN")
//                .antMatchers("/productsLogin").hasAuthority("CLIENT")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
////                    .usernameParameter("username")
//////                .defaultSuccessUrl("/productsLogin")
//                .and()
//                .logout().logoutSuccessUrl("/products").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/403");
                .antMatchers("/productsLogin").hasAuthority("CLIENT")
                .antMatchers("/transportorPage").hasAuthority("TRANSPORTOR")
                .antMatchers("/adminPage","/productsList").hasAuthority("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("username")
                .successHandler((request, response, authentication) -> {
                    CustomUserDetails userDetails= (CustomUserDetails) authentication.getPrincipal();
                    if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                        response.sendRedirect("/adminPage");
                    } else {
                        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("CLIENT"))) {
                            response.sendRedirect("/productsLogin");
                        }
                        else {
                            response.sendRedirect("/transportorPage");
                        }
                    }
                })
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/products").permitAll();

    }


}
