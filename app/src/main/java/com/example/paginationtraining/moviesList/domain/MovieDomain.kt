package com.example.paginationtraining.moviesList.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.paginationtraining.moviesList.Constants.IMAGE_BASE_URL
import com.example.paginationtraining.moviesList.Constants.IMAGE_SIZE
import com.example.paginationtraining.moviesList.data.local.AppTypeConverter

@Entity("movies")
@TypeConverters(value = [AppTypeConverter::class])
data class MovieDomain(
	val adult: Boolean,
	val backdropPath: String,
	val genreIds: List<Int>,
	@PrimaryKey
	val id: Int,
	val originalLanguage: String,
	val originalTitle: String,
	val overview: String,
	val popularity: Double,
	val posterPath: String,
	val releaseDate: String,
	val title: String,
	val video: Boolean,
	val voteAverage: Double,
	val voteCount: Int,
)