package com.example.abdulla.session7.retrofit

import com.example.abdulla.session7.model.User
import com.example.abdulla.session7.model.Users
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val service = Retrofit.Builder().baseUrl("https://gorest.co.in")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient)
        .build()
        .create(ApiService::class.java)


    fun getusers(): Observable<Users> = this.service.getUsers()

    fun createusers(user: User): Observable<User> = this.service.createUser(user)


    private val httpClient: OkHttpClient
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient()
                .newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val request: Request = chain.request()
                        val newRequest: Request = request.newBuilder()
                            .addHeader(
                                "Authorization",
                                "Bearer 39e3a3bbb7e41898018dd60046ef639dcb7a5d1344a712d5d54b15ad82b3e45b"//tak ne delat`
                            )
                            .build()
                        return chain.proceed(newRequest)
                    }
                }).build()
        }


}