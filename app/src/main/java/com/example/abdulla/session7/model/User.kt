package com.example.abdulla.session7.model

import kotlinx.serialization.Serializable


data class Users(val data: ArrayList<User>)
@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val gender: Gender,
    val status: Status,
    val field :String? = null,
    val message : String? = null,

)
@Serializable
enum class Gender { male, female; }
@Serializable
enum class Status {active, inactive; }
