package com.example.paginationtraining.moviesList.data.local

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paginationtraining.moviesList.domain.Movie
import com.example.paginationtraining.moviesList.domain.MyResult
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(movies: List<Movie>)
    @Query("SELECT * FROM movie ORDER BY title ASC")
    suspend fun readMovies(): List<Movie>
//
//    @Query("SELECT * FROM movie WHERE page = :page LIMIT 1")
//    suspend fun getPage(page: Int): MyResult?

}