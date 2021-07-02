package com.danilo.repository

import com.danilo.model.Planet
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PlanetRepository: JpaRepository <Planet, Long>  {

}