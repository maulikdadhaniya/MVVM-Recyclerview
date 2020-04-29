package com.example.testmvvm.repo

import com.example.testmvvm.retrofit.MoviesAPI
import com.example.testmvvm.retrofit.SafeAPIRequest

class MovieRepository(
    private val api: MoviesAPI
) : SafeAPIRequest() {
     suspend fun getMovies() = apiRequest { api.getMovies("jayarbuda@123") }
}