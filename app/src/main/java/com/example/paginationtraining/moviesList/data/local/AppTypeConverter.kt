package com.example.paginationtraining.moviesList.data.local

import androidx.room.TypeConverter
import com.example.paginationtraining.moviesList.domain.MovieDomain
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AppTypeConverter {
    //convert list of movies
    @TypeConverter
    fun fromList(movies: List<MovieDomain>?): String? {
        return movies?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toList(data: String?): List<MovieDomain>? {
        return data?.let {
            val type = object : TypeToken<List<MovieDomain>>() {}.type
            Gson().fromJson<List<MovieDomain>>(it, type)
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