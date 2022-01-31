package com.codewithabe.AAiT.config;


import com.codewithabe.AAiT.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   @Autowired
   private CustomUserDetailsService customUserDetailsService;
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

   @Bean
   public DaoAuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
       auth.setUserDetailsService(customUserDetailsService);
       auth.setPasswordEncoder(passwordEncoder());
       return auth;
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authenticationProvider());
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       http.authorizeRequests()
               .antMatchers(
                       "/signup","/images/**","/js/**","/css/**").permitAll()
               .antMatchers("/admindashboard").hasAnyAuthority("ROLE_ADMIN")
               .antMatchers("/home").hasAnyAuthority("ROLE_USER")
               .anyRequest().authenticated()
               .and()
               .formLogin()
               .loginPage("/login")
               .usernameParameter("email")
               .successHandler(loginSuccessHandler)
               .permitAll()
               .and()
               .logout()
               .invalidateHttpSession(true)
               .clearAuthentication(true)
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               .logoutSuccessUrl("/login?logout")
               .permitAll()
               .and()
               .rememberMe()
               .key("ABCDEFGHIJKLMNOPQRSTUVWXYZ_1234567890")
               .tokenValiditySeconds(7*24860*60);

   }
   @Autowired private LoginSuccessHandler loginSuccessHandler;
}
