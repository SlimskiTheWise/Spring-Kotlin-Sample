package com.sample.backend_sample.auth

import com.sample.backend_sample.auth.dto.LoginDto
import com.sample.backend_sample.auth.response.LoginResponseDto
import com.sample.backend_sample.auth.security.CustomUserDetailsService
import com.sample.backend_sample.jwt.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authManager: AuthenticationManager,
    private val jwtService: JwtService,
    private val customUserDetailsService: com.sample.backend_sample.auth.security.CustomUserDetailsService,
) {
    fun authenticate(dto: com.sample.backend_sample.auth.dto.LoginDto): com.sample.backend_sample.auth.response.LoginResponseDto {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(dto.email, dto.password),
        )

        val user = customUserDetailsService.loadUserByUsername(dto.email)

        val token = jwtService.createToken(user.username)

        return com.sample.backend_sample.auth.response.LoginResponseDto(token)
    }
}