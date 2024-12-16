package com.example.paginationtraining.moviesList.presentation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginationtraining.moviesList.domain.Movie
import com.example.paginationtraining.R

class MoviesAdatper(val context: Context) : PagingDataAdapter<Movie, MoviesAdatper.MoviesVH>(DIFF_UTIL) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesVH(view)
    }

    override fun onBindViewHolder(holder: MoviesVH, position: Int) {
        val movie = getItem(position)
        holder.testText.text = movie?.title
        val baseUrl = "https://image.tmdb.org/t/p/"
        val size = "w500"
        val posterImage = movie?.poster_path
        val imageLink = "$baseUrl$size$posterImage"
        Glide.with(context)
            .load(imageLink)
            .into(holder.movieImage)
    }

    class MoviesVH(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val testText = itemView.findViewById<TextView>(R.id.textView)
        val movieImage = itemView.findViewById<ImageView>(R.id.movie_img)
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}