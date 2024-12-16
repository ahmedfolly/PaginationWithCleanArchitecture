package com.example.paginationtraining.moviesList.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationtraining.moviesList.domain.Movie

class MoviesPagingSource(private val apiService: APIService) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        Log.d("TAG", "Requesting page: $page")
        return try {
            val response = apiService.getMovies(page = page)
            Log.d("TAG", "load: ${response.page}")
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1)
        } catch (e: Exception) {
            Log.d("TAG", "load: ${e.message}")
            LoadResult.Error(e)
        }
    }
}