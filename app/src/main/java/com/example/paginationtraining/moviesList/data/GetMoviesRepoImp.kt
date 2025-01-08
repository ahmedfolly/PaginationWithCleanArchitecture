package com.example.paginationtraining.moviesList.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paginationtraining.moviesList.data.local.MoviesDao
import com.example.paginationtraining.moviesList.domain.GetMoviesRepo
import com.example.paginationtraining.moviesList.domain.MovieDomain
import kotlinx.coroutines.flow.Flow

class GetMoviesRepoImp(private val apiService: APIService,private val dao: MoviesDao) : GetMoviesRepo {
    override  fun getMovies(): Flow<PagingData<MovieDomain>>  =
        Pager(config = PagingConfig(pageSize = 10, maxSize = 50),
            pagingSourceFactory = { MoviesPagingSource(apiService,dao)})
            .flow
}