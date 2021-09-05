package com.davidnardya.flickrgalleryapp.model

class Image (
    val id: String,
    val farm: String,
    val server: String,
    val secret: String,
    val url_s: String,
        )

class FirstObject (
    val photos: SecondObject,
    val stat: String,
        )

class SecondObject(
    val photo: List<Image>,
    val page: Int,
    val pages: Int
)