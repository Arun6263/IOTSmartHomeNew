package com.akshar.iot.smarthome.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;
 
 @Autowired
 private DataSource dataSource;
 
 private final String USERS_QUERY = "select email, password, active from user where email=?";
 private final String ROLES_QUERY = "select u.email, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.jdbcAuthentication()
   .usersByUsernameQuery(USERS_QUERY)
   .authoritiesByUsernameQuery(ROLES_QUERY)
   .dataSource(dataSource)
   .passwordEncoder(bCryptPasswordEncoder);
  
 }
 
// private static final String[] AUTH_WHITELIST = {
//         // -- swagger ui
//         "/v2/api-docs",
//         "/swagger-resources",
//         "/swagger-resources/**",
//         "/configuration/ui",
//         "/configuration/security",
//         "/swagger-ui.html",
//         "/webjars/**",
//         "swagger-ui.html#/"
//         // other public endpoints of your API may be appended to this array
// };
 
 @Override
 protected void configure(HttpSecurity http) throws Exception{

  http.authorizeRequests()
   .antMatchers("/").permitAll()
   //.antMatchers(AUTH_WHITELIST).permitAll()
   .antMatchers( "/public/**").permitAll()
   .antMatchers( "/getallcustomers").permitAll()
   .antMatchers( "/changePassword").permitAll()
   .antMatchers( "/logout").permitAll()
   .antMatchers("/login").permitAll()
   .antMatchers("/getAllUsers").permitAll()
   .antMatchers("/mqtt/send").permitAll()
   .antMatchers("/mqtt/get").permitAll()
   .antMatchers("/new_user").permitAll()
   .antMatchers("/signin").permitAll()
   .antMatchers("/signup").permitAll()	 
   .antMatchers("/logout").permitAll()	
   .antMatchers("/home/**").hasAnyAuthority("ADMIN")   
   .anyRequest().authenticated().and()
   .formLogin().loginPage("/login").failureUrl("/login?error=true")
   .defaultSuccessUrl("/home/home")
   .usernameParameter("email")
   .passwordParameter("password")
   .and().logout()
   .logoutSuccessUrl("/")
   .and().rememberMe()
   .tokenRepository(persistentTokenRepository())
   .tokenValiditySeconds(60*60)
   .and().exceptionHandling().accessDeniedPage("/access_denied");
  
  
 }
 
 @Bean
 public PersistentTokenRepository persistentTokenRepository() {
  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
  db.setDataSource(dataSource);
  
  return db;
 }
}