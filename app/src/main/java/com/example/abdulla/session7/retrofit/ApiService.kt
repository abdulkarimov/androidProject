package com.example.abdulla.session7.retrofit

import com.example.abdulla.session7.model.User
import com.example.abdulla.session7.model.Users
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/public/v1/users")
    fun getUsers(): Observable<Users>
    @POST("/public/v1/users")
    fun createUser(@Body user:User):Observable<User>


}