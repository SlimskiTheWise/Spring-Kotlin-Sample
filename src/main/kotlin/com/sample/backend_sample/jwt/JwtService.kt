package com.sample.backend_sample.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@PropertySource("classpath:jwt.yml")
@Service
class JwtService(
    @Value("\${secret-key}")
    private val secretKey: String,
    @Value("\${expiration-hours}")
    private val expirationHours: Long,
    @Value("\${issuer}")
    private val issuer: String
) {
    fun createToken(userSpecification: String): String {
        val bytes = Base64.getDecoder().decode(secretKey)
        val key = Keys.hmacShaKeyFor(bytes)
        return Jwts.builder()
            .subject(userSpecification)
            .issuer(issuer)
            .issuedAt(Date.from(Instant.now()))
            .expiration(Date.from(Instant.now().plus(expirationHours, ChronoUnit.HOURS)))
            .signWith(key)
            .compact()
    }

    fun isValid(token: String, userDetails: UserDetails): Boolean {
        val email = extractEmail(token)
        return userDetails.username == email && !isExpired(token)
    }

    fun extractEmail(token: String): String? =
        getAllClaims(token)
            .subject

    fun isExpired(token: String): Boolean =
        getAllClaims(token)
            .expiration
            .before(Date(System.currentTimeMillis()))

    private fun getAllClaims(token: String): Claims {
        val bytes = Base64.getDecoder().decode(secretKey)
        val key = Keys.hmacShaKeyFor(bytes)

        val parser = Jwts.parser().verifyWith(key)
            .build()
        return parser
            .parseSignedClaims(token)
            .payload
    }
}
