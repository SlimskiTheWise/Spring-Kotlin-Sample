package com.sample.backend_sample.unit

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UnitRepository : JpaRepository<Unit, Long> {
    @Query("SELECT u FROM Unit u JOIN FETCH u.property ORDER BY u.id DESC")
    fun findAllUnitsWithProperty(): List<Unit>

}

