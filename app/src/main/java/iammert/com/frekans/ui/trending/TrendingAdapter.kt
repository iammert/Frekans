package iammert.com.frekans.ui.trending

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import iammert.com.data.remote.model.Radio
import iammert.com.frekans.databinding.ItemTrendingBinding

/**
 * Created by mertsimsek on 30/11/2017.
 */
class TrendingAdapter(private var trendingList: List<Radio> = ArrayList()) : RecyclerView.Adapter<TrendingAdapter.TrendingItemViewHolder>() {

    fun setTrendingList(trendingList: List<Radio>){
        this.trendingList = trendingList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TrendingItemViewHolder {
        return TrendingItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TrendingItemViewHolder, position: Int) {
        holder.bind(trendingList[position])
    }

    override fun getItemCount() = trendingList.size

    class TrendingItemViewHolder(private var binding: ItemTrendingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: Radio) = with(binding) {
            binding.radio = genre
            executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup?): TrendingItemViewHolder {
                val trendingBinding = ItemTrendingBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                return TrendingItemViewHolder(trendingBinding)
            }
        }
    }
}