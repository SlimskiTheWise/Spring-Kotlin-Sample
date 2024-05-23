package com.sample.backend_sample.user

import com.sample.backend_sample.user.dto.CreateUserDto
import jakarta.persistence.*
import org.springframework.security.crypto.password.PasswordEncoder

@Entity
@Table(name = "Users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "email", nullable = false)
    var email: String = "",

    @Column(name = "password", nullable = false)
    var password: String = "",

    @Column(name = "name", nullable = false)
    var name: String = ""
) {
    companion object {
        fun from(dto: CreateUserDto, encoder: PasswordEncoder) = User(
            email = dto.email,
            password = encoder.encode(dto.password),
            name = dto.name,
        )
    }


}
