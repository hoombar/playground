package com.rdydev.playground.data.model

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: latLong
)

data class latLong(val lat: String, val lng: String)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)