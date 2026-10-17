package com.example.week4vp

data class Car(
    val id: Int,
    val name: String,
    val fuelType: String,
    val transmission: String,
    val year: String,
    val mileage: String,
    val price: String,
    val location: String,
    val imageRes: Int,
    val description: String,
    var isFavorite: Boolean = false
)