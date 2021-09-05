package com.davidnardya.flickrgalleryapp.model

//The image itself form the JSON
class Image (
    val id: String,
    val farm: String,
    val server: String,
    val secret: String,
    val url_s: String,
        )

//The outermost object of the JSON
class FirstObject (
    val photos: SecondObject,
        )

//The second object inside the FirstObject in the JSON
class SecondObject(
    val photo: List<Image>,
)