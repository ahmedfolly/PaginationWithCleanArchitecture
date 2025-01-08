package com.example.paginationtraining.moviesList.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginationtraining.moviesList.domain.MovieDomain
import com.example.paginationtraining.R

class MoviesAdapter() : PagingDataAdapter<MovieDomain, MoviesAdapter.MoviesVH>(DIFF_UTIL) {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): MoviesVH {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
		return MoviesVH(view)
	}

	override fun onBindViewHolder(holder: MoviesVH, position: Int) {
		val movie = getItem(position)
		if (movie!=null){
			holder.bindsToVH(movie)
		}
	}

	class MoviesVH(val itemView: View) : RecyclerView.ViewHolder(itemView) {
		val testText = itemView.findViewById<TextView>(R.id.textView)
		val movieImage = itemView.findViewById<ImageView>(R.id.movie_img)
		fun bindsToVH(movieDomain: MovieDomain) {
			testText.text = movieDomain.title
			val imageLink = movieDomain.posterPath
			Glide.with(itemView.context)
				.load(imageLink)
				.into(movieImage)
		}
	}

	companion object {
		private val DIFF_UTIL = object : DiffUtil.ItemCallback<MovieDomain>() {
			override fun areItemsTheSame(
				oldItem: MovieDomain,
				newItem: MovieDomain
			): Boolean {
				return oldItem.id == newItem.id
			}

			override fun areContentsTheSame(
				oldItem: MovieDomain,
				newItem: MovieDomain
			): Boolean {
				return oldItem == newItem
			}

		}
	}
}