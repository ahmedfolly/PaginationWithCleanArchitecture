package com.example.paginationtraining.moviesList.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.paginationtraining.moviesList.data.local.AppTypeConverter
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "movies")
@TypeConverters(value = [AppTypeConverter::class])
data class MyResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)