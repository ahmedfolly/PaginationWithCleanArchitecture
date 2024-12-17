package com.example.paginationtraining.moviesList.data.local

import androidx.room.TypeConverter
import com.example.paginationtraining.moviesList.domain.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AppTypeConverter {
    //convert list of movies
    @TypeConverter
    fun fromList(movies: List<Movie>?): String? {
        return movies?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toList(data: String?): List<Movie>? {
        return data?.let {
            val type = object : TypeToken<List<Movie>>() {}.type
            Gson().fromJson<List<Movie>>(it, type)
        }
    }

    //convert list of genre_ids
    @TypeConverter
    fun fromGenreIds (genre_ids: List<Int>?): String? {
        return genre_ids?.let {
            Gson().toJson(it)
        }
    }

    @TypeConverter
    fun toGenreIds (data: String?): List<Int>? {
        return data?.let {
            val type = object : TypeToken<List<Int>>() {}.type
            Gson().fromJson<List<Int>>(it, type)
        }
    }
}