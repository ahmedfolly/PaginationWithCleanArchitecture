package com.example.paginationtraining.moviesList.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paginationtraining.moviesList.domain.GetMoviesRepo
import com.example.paginationtraining.moviesList.domain.Movie
import kotlinx.coroutines.flow.Flow

class GetMoviesRepoImp(private val apiService: APIService) : GetMoviesRepo {
    override  fun getMovies(): Flow<PagingData<Movie>>  =
        Pager(config = PagingConfig(pageSize = 10, maxSize = 50),
            pagingSourceFactory = { MoviesPagingSource(apiService)})
            .flow
}