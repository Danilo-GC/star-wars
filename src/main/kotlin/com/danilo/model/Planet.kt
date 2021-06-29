package com.danilo.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity
@Introspected
data class Planet (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 1,
    @Column
    var name: String,
    @Column
    val weather: String,
    @Column
    val terrain: String,
    @Column
    val hostile: Boolean,
    )