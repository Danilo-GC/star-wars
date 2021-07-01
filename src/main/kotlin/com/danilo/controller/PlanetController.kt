package com.danilo.controller

import com.danilo.model.Planet
import com.danilo.service.PlanetService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Post


@Controller(value = "/planets")
class PlanetController(private val planetService: PlanetService) {


    @Get(value = "/{id}")
    fun getById(id: Long): HttpResponse<Planet> {
        return HttpResponse.ok(this.planetService.getById(id))
    }

    @Get
    fun getAll(): HttpResponse<List<Planet>> {
        return HttpResponse.ok(planetService.getAll())
    }

    @Post
    fun addPlanet(@Body planet: Planet): HttpResponse<Planet> {
        return HttpResponse.created(planetService.addPlanet(planet))
    }

    @Put(value = "/{id}")
    fun updatePlanet(@PathVariable id: Long, @Body planet: Planet): HttpResponse<Planet> {
        val newPlanet = Planet(id, planet.name, planet.weather, planet.terrain, planet.hostile)
        return  HttpResponse.ok<Planet?>().body(planetService.updatePlanet(id,newPlanet))
    }

    @Delete(value = "/{id}")
    fun deletePlanet(id: Long): HttpResponse<Unit> {
        planetService.deletePlanet(id)
        return HttpResponse.noContent()
    }


}


