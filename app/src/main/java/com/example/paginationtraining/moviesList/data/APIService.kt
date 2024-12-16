package com.example.paginationtraining.moviesList.data

import com.example.paginationtraining.moviesList.domain.MyResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/3/discover/movie")
    suspend fun getMovies(
        @Query("page")
        page:Int = 1,
        @Query("api_key")
        apiKey:String = "a3674b222a9813d0520b204500146b8a"
    ): MyResult
}