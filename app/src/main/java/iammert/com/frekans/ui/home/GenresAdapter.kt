package iammert.com.frekans.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import iammert.com.frekans.data.remote.model.Genre
import iammert.com.frekans.databinding.ItemGenreBinding

/**
 * Created by mertsimsek on 15/11/2017.
 */
class GenresAdapter(private var genres: List<Genre> = ArrayList()) : RecyclerView.Adapter<GenresAdapter.GenreItemViewHolder>() {

    fun setGenres(genres: List<Genre>){
        this.genres = genres
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GenreItemViewHolder = GenreItemViewHolder.create(parent)

    override fun onBindViewHolder(holder: GenreItemViewHolder, position: Int) = holder.bind(genres[position])

    override fun getItemCount() = genres.size

    class GenreItemViewHolder(private var binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: Genre) = with(binding) {
            binding.genre = genre
        }

        companion object {
            fun create(parent: ViewGroup?): GenreItemViewHolder {
                val genreBinding = ItemGenreBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                return GenreItemViewHolder(genreBinding)
            }
        }
    }
}