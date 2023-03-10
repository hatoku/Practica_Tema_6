package com.dam.api.models

import jakarta.persistence.*

@Entity
@Table(name = "movie")
class Movie(
    @Id
    @Column(name = "id")
    var id: Int,

    @Column(name = "title")
    var title: String,

    @Column(name = "director")
    var director: String,

    @Column(name = "time")
    var time: String,

    @Column(name = "trailer")
    var trailer: String,

    @Column(name = "poster_image")
    var poster_image: String
) {
}