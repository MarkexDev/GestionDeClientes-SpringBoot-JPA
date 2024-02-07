package com.bolsadeideas.springboot.app;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.bolsadeideas.springboot.app.auth.handler.LoginSuccessHandler;

@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig {
	
	@Autowired
	private LoginSuccessHandler loginSuccess;
 
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
 
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 
        manager.createUser(User.withUsername("marcos")
                               .password(passwordEncoder().encode("12345"))
                               .roles("USER").build());
 
        manager.createUser(User.withUsername("admin")
                               .password(passwordEncoder().encode("12345"))
                               .roles("ADMIN", "USER").build());
 
        return manager;
    }
 
    @Bean   
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {      
     return new MvcRequestMatcher.Builder(introspector);   
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        RequestMatcher publicMatchers = new OrRequestMatcher(
                new AntPathRequestMatcher("/"),
                new AntPathRequestMatcher("/locale"),
                new AntPathRequestMatcher("/css/**"),
                new AntPathRequestMatcher("/js/**"),
                new AntPathRequestMatcher("/api/clientes/**"), 
                // ACCESO REST url: localhost:8080/api/clientes/listar?format=json 
                //(Mediante el ClienteRestController.java)
                //BUG: por el momento solo se puede acceder al iniciar sesion como ADMIN
                new AntPathRequestMatcher("/img/**"));
 
        RequestMatcher userMatchers = new OrRequestMatcher(
                new AntPathRequestMatcher("/uploads/**"),
                new AntPathRequestMatcher("/listar"),
                new MvcRequestMatcher(null, "/ver/**"));
 
        RequestMatcher adminMatchers = new OrRequestMatcher(
                new AntPathRequestMatcher("/factura/**"),
                new AntPathRequestMatcher("/listar**"),
                new AntPathRequestMatcher("/form/**"), //Acceso REST (Mediante el Clientecontroller.java)
                //PARA JSON, USAR EL ENLACE: localhost:8080/listar-rest?format=json
            	//PARA XML, USAR EL ENLACE: localhost:8080/listar-rest?format=xml
                new AntPathRequestMatcher("/eliminar/**"));
 
        http
                .authorizeHttpRequests(authorize -> {
                    try {
                        authorize
                                .requestMatchers(publicMatchers).permitAll()
                                .requestMatchers(userMatchers).hasAnyRole("USER")
                                .requestMatchers(adminMatchers).hasRole("ADMIN")
                                .anyRequest().authenticated()
 
                ;
 
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
 
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .successHandler(loginSuccess)
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling(e ->{
                    e.accessDeniedPage("/error_403");
                })
 
                .rememberMe(Customizer.withDefaults());
 
        return http.build();
 
    }
}