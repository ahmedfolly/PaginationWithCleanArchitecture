package com.example.paginationtraining

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationtraining.moviesList.presentation.MoviesAdatper
import com.example.paginationtraining.moviesList.presentation.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val moviesViewModel: MoviesViewModel by viewModels()
    lateinit var moviesAdatper: MoviesAdatper
    private lateinit var moviesContainer:RecyclerView
    private lateinit var progressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesContainer = findViewById<RecyclerView>(R.id.movies_list)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        moviesAdatper = MoviesAdatper(this)
        lifecycleScope.launch(Dispatchers.IO){
            moviesViewModel.movies.collectLatest{data->
                moviesAdatper.submitData(data)
            }
        }
        lifecycleScope.launch {
            moviesAdatper.loadStateFlow.collectLatest { loadState ->
                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                        || loadState.source.append is LoadState.Loading
            }
        }
        initMoviesContainer(moviesContainer)
    }
    fun initMoviesContainer(moviesContainer: RecyclerView){
        moviesContainer.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter =  moviesAdatper
        }

    }
}