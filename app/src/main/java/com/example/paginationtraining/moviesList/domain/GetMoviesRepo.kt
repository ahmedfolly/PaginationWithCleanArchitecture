package com.example.paginationtraining.moviesList.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GetMoviesRepo {
     fun getMovies(): Flow<PagingData<MovieDomain>>
}