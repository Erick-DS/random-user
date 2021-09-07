package com.example.randomuser.profile.model

data class Location(
    val city: String,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: Street,
)