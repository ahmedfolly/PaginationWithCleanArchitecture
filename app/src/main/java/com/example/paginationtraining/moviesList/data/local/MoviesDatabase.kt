package com.example.paginationtraining.moviesList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paginationtraining.moviesList.domain.MovieDomain

@Database(entities = [MovieDomain::class], version =4)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getDao():MoviesDao
}