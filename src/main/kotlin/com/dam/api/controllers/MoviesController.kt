package com.dam.api.controllers

import com.dam.api.models.Movie
import com.dam.api.services.MoviesServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
class MoviesController {
    @Autowired
    lateinit var moviesService: MoviesServiceImpl

    @GetMapping("")
    fun getAll(): ResponseEntity<MutableList<Movie>> {
        var listMovies: MutableList<Movie>? = mutableListOf()
        listMovies = moviesService.all
        return ResponseEntity(listMovies, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getOneMovie(@PathVariable id: String): ResponseEntity<Movie>{
        var idMovie: Long = id.toLong()
        var movie: Movie? = moviesService[idMovie]
        return ResponseEntity<Movie>(movie, HttpStatus.OK)
    }
}