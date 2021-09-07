package com.example.randomuser.profile.model

data class Result(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val name: Name,
    val nat: String,
    val phone: String,
)