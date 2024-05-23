package com.sample.backend_sample.property

import jakarta.persistence.*

@Entity
@Table(name = "Properties")
class Property(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name", nullable = false)
    var name: String = "",
)