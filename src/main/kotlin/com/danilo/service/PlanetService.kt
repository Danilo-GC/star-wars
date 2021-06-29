package com.danilo.service

import com.danilo.model.Planet

interface PlanetService {

    fun getById(id:Long): Planet?
    fun getAll(): List<Planet>
    fun addPlanet(planet: Planet): Planet
    fun updatePlanet(id: Long, planet: Planet)
    fun deletePlanet(id: Long)


}