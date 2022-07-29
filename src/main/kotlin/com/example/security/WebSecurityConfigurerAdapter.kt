package com.example.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig @Autowired constructor(private val userRepository: IUserRepository) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(MyUserDetailsService(userRepository))
    }
}
