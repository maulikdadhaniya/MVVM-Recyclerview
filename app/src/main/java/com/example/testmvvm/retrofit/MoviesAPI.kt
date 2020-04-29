package com.example.testmvvm.retrofit

import com.example.testmvvm.response.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MoviesAPI {

    @FormUrlEncoded
    @POST("amara_vise.php")
    suspend fun getMovies(@Field("i_key") i_key: String): Response<MovieResponse>

    companion object {
        operator fun invoke(): MoviesAPI {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://8gamanjana.com/api/")
                .build()
                .create(MoviesAPI::class.java)

        }
    }
}