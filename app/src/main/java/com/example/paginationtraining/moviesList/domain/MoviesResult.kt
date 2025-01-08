package com.example.paginationtraining.moviesList.domain

import androidx.room.TypeConverters
import com.example.paginationtraining.moviesList.data.local.AppTypeConverter
import com.example.paginationtraining.moviesList.data.model.MoviesDto
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "movies")
@TypeConverters(value = [AppTypeConverter::class])
data class MoviesResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoviesDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)