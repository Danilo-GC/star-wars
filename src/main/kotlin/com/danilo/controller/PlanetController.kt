package com.danilo.controller

import com.danilo.model.Planet
import com.danilo.service.PlanetService
import io.micronaut.http.HttpMethod
import io.micronaut.http.annotation.*
import javax.inject.Inject


@Controller (value = "/planets")
class PlanetController{

    @Inject
    lateinit var planetService: PlanetService

    @Get (value = "/{id}")
    fun getById(id:Long): Planet? {
        return this.planetService.getById(id)
    }

    @Get
    fun getAll(): List<Planet> {
        return this.planetService.getAll()
    }

    @Post
    fun addPlanet(@Body planet: Planet): Planet {
        return planetService.addPlanet(planet)
    }

    @Put (value = "/{id}")
    fun updatePlanet(@PathVariable id: Long,@Body planet: Planet) {
        return planetService.updatePlanet(id,planet)
    }

    @Delete (value = "/{id}")
    fun deletePlanet (id: Long){
        return planetService.deletePlanet(id)
    }


    }
