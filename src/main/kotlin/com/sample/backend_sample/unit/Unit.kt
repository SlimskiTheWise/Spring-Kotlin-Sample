package com.sample.backend_sample.unit

import com.sample.backend_sample.property.Property
import jakarta.persistence.*

@Entity
@Table(name = "Units")
class Unit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name", nullable = false)
    var name: String = "",

    @Column(name = "block", nullable = false)
    var block: String = "",

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Property::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    var property: Property = Property()
)

