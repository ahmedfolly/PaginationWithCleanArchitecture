package com.example.paginationtraining.moviesList.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MoviesDto(
	val adult: Boolean,
	@SerializedName("backdrop_path")
	val backdropPath: String? = null,
	@SerializedName("genre_ids")
	val genreIds: List<Int>? = null,
	@PrimaryKey
	val id: Int? = null,
	@SerializedName("original_language")
	val originalLanguage: String? = null,
	@SerializedName("original_title")
	val originalTitle: String? = null,
	val overview: String? = null,
	val popularity: Double? = null,
	@SerializedName("poster_path")
	val posterPath: String? = null,
	@SerializedName("release_date")
	val releaseDate: String? = null,
	val title: String? = null,
	val video: Boolean? = null,
	@SerializedName("vote_average")
	val voteAverage: Double? = null,
	@SerializedName("vote_count")
	val voteCount: Int? = null
)

