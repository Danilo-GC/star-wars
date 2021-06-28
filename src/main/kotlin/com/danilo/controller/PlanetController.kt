package com.danilo.controller

import com.danilo.model.Planet
import com.danilo.repository.PlanetRepository
import io.micronaut.http.HttpMethod
import io.micronaut.http.annotation.*
import java.util.*


@Controller (value = "/planets")
class PlanetController(private val planetRepository: PlanetRepository) {

    @Get (value = "/{id}")
    fun getById(id:Long): Optional<Planet> {
        return planetRepository.findById(id)
    }

    @Get
    fun getAll(): List<Planet> {
        return planetRepository.findAll()
    }

    @Post
    fun addPlanet(@Body planet: Planet): Planet {
        return planetRepository.save(planet)
    }

    @Put (value = "/{id}")
    fun updatePlanet(@PathVariable id: Long, planet: Planet): Planet {
        return planetRepository.update(updatePlanet(id,planet))
    }

    @Delete (value = "/{id}")
    fun deletePlanet (id: Long){
        return planetRepository.deleteById(id)
    }


    }
