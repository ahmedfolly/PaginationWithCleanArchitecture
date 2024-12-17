package com.example.paginationtraining.moviesList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paginationtraining.moviesList.domain.Movie
import com.example.paginationtraining.moviesList.domain.MyResult

@Database(entities = [Movie::class], version =2)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getDao():MoviesDao
}