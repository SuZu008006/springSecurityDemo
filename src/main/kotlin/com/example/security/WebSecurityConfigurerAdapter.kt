package com.example.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@EnableWebSecurity
class SecurityConfig @Autowired constructor(private val userRepository: IUserRepository) :
    WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .antMatcher("/**")
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .httpBasic().realmName("Your secret area.")
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .authenticationProvider(DemoBasicAuthProvider(userRepository))
    }
}
