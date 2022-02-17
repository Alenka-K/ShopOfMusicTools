package com.example.shopofmusictools.security;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = Logger.getLogger(WebSecurityConfig.class);

    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("admin").password("admin123").roles("ADMIN").build());
        manager.createUser(users.username("user").password("user123").roles("USER").build());
        return manager;
    }

    @Override
    public void configure(WebSecurity web) {
        try {
            super.configure(web);
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(  "/")
                .permitAll()
                .antMatchers("/viewAllTools", "/viewAllOrders").authenticated().and()
                .formLogin().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
