package com.example.paginationtraining.moviesList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paginationtraining.moviesList.domain.GetMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMoviesListUseCase: GetMoviesListUseCase) : ViewModel() {
    val movies = getMoviesListUseCase.invoke().cachedIn(viewModelScope)
}