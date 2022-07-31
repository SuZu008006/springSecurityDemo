package com.example.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class DemoBasicAuthProvider(private val userRepository: IUserRepository) : AuthenticationProvider {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val inputName: String = authentication.name
        val inputPass: String = authentication.credentials.toString()
        val getUser = userRepository.findByEmail(inputName)

        return if ((inputName == getUser?.email) && BCryptPasswordEncoder(10).matches(inputPass, getUser.pass)) {
            println("ユーザー名とパスワードが正しい")
            UsernamePasswordAuthenticationToken(inputName, inputPass, authentication.authorities)
        } else {
            println("ユーザー名やパスワードが正しくない")
            throw BadCredentialsException("ユーザー名やパスワードが正しくない")
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}