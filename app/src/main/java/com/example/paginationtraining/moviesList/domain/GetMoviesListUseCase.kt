package com.example.paginationtraining.moviesList.domain

class GetMoviesListUseCase(private val repo: GetMoviesRepo) {
     operator fun invoke() = repo.getMovies()
}