package com.example.paginationtraining.moviesList.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paginationtraining.moviesList.domain.MovieDomain

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(movies: List<MovieDomain>)
    @Query("SELECT * FROM movies")
    suspend fun readMovies(): List<MovieDomain>
}