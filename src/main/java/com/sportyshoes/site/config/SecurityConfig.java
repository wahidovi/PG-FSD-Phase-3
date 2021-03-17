package com.sportyshoes.site.config;

public class SecurityConfig {
}

/*
 * @Configuration public class SecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { PasswordEncoder encoder =
 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
 * 
 * auth .inMemoryAuthentication() .withUser("user") .password("user")
 * .roles("USER") .and() .withUser("admin") .password("admin") .roles("USER",
 * "ADMIN"); }
 * 
 * @Bean public PasswordEncoder getPasswordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http .authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic();
 * 
 * 
 * 
 * http .authorizeRequests() .antMatchers("/*").hasAnyAuthority("ADMIN","USER")
 * .antMatchers("/admin/**").hasAuthority("ADMIN")
 * .antMatchers("/productList/**").hasAnyAuthority("ADMIN","USER")
 * .anyRequest().authenticated() .and() .formLogin().permitAll() .and()
 * .logout().permitAll();
 * 
 * 
 * //http.authorizeRequests() //.antMatchers("/admin/**").hasRole("ADMIN")
 * //.antMatchers("/productList/**").hasAnyRole("ADMIN","USER")
 * //.antMatchers("/").permitAll() //.and().formLogin(); }
 * 
 * }
 */
