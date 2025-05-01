package com.csrf.auth.configuration;


import com.csrf.auth.Service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customOptimizer->customOptimizer.disable());
        httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/admin/**").hasRole("ADMIN").
                requestMatchers("/user/**").hasAnyRole("USER","ADMIN").
                requestMatchers("/public/**").permitAll().
                anyRequest().authenticated());
        //httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
       return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        List<UserDetails> users=new ArrayList<UserDetails>();
//        UserDetails user1=User.withDefaultPasswordEncoder().
//                username("ishwarya").
//                password("admin@123").
//                roles("admin").
//                build();
//        UserDetails user2=User.withDefaultPasswordEncoder().
//                username("ishwarya.v").
//                password("admin@123").
//                roles("admin").
//                build();
//        UserDetails user3=User.withDefaultPasswordEncoder().
//                username("ishwarya.s").
//                password("admin@123").
//                roles("admin").
//                build();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        return new InMemoryUserDetailsManager(users);//varargs
//
////        return new InMemoryUserDetailsManager(user1,user2,user3);//varargs
//
//    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
         provider.setUserDetailsService(userDetailsService);
         return provider;
    }
}
