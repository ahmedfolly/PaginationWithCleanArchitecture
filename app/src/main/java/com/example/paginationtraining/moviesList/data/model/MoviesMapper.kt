package com.example.paginationtraining.moviesList.data.model

import com.example.paginationtraining.moviesList.Constants.IMAGE_BASE_URL
import com.example.paginationtraining.moviesList.Constants.IMAGE_SIZE
import com.example.paginationtraining.moviesList.domain.MovieDomain

private fun MoviesDto.toMoviesDomain(): MovieDomain {
	return MovieDomain(
		adult = adult,
		backdropPath = backdropPath ?: "",
		genreIds = genreIds ?: emptyList(),
		id = id ?: 1,
		originalLanguage = originalLanguage ?: "",
		originalTitle = originalTitle ?: "",
		overview = overview ?: "",
		popularity = popularity ?: 0.0,
		posterPath = "${IMAGE_BASE_URL}${IMAGE_SIZE}${posterPath}",
		releaseDate = releaseDate ?: "",
		title = title ?: "",
		video = video == true,
		voteAverage = voteAverage ?: 0.0,
		voteCount = voteCount ?: 1
	)
}

fun List<MoviesDto>.toMovies(): List<MovieDomain> {
	return map { moviesDto -> moviesDto.toMoviesDomain() }
}