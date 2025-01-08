package com.example.paginationtraining.moviesList.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationtraining.moviesList.data.local.MoviesDao
import com.example.paginationtraining.moviesList.data.model.toMovies
import com.example.paginationtraining.moviesList.domain.MovieDomain

class MoviesPagingSource(private val apiService: APIService, private val dao: MoviesDao) :
    PagingSource<Int, MovieDomain>() {
    override fun getRefreshKey(state: PagingState<Int, MovieDomain>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDomain> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getMovies(page = page)
            val remoteMovies = response.results
            val movies = remoteMovies.toMovies()
            dao.insertAll(movies)
            LoadResult.Page(
                data = movies,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (_: Exception) {
                val localData = dao.readMovies()
                LoadResult.Page(
                    data = localData,
                    prevKey = null,
                    nextKey = null
                )
        }
    }
}
//new line added to second feature to train on git flow
//new line added to third