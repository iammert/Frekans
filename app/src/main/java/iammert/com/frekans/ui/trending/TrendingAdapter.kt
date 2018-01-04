package iammert.com.frekans.ui.trending

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import iammert.com.data.local.entity.RadioEntity
import iammert.com.frekans.databinding.ItemTrendingBinding

/**
 * Created by mertsimsek on 30/11/2017.
 */
class TrendingAdapter(private var trendingList: List<RadioEntity> = ArrayList()) : RecyclerView.Adapter<TrendingAdapter.TrendingItemViewHolder>() {

    lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClicked(radioEntity: RadioEntity)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun setTrendingList(trendingList: List<RadioEntity>) {
        this.trendingList = trendingList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TrendingItemViewHolder {
        return TrendingItemViewHolder.create(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: TrendingItemViewHolder, position: Int) {
        holder.bind(trendingList[position])
    }

    override fun getItemCount() = trendingList.size

    class TrendingItemViewHolder(private var binding: ItemTrendingBinding,
                                 private var itemClickListener: OnItemClickListener?) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { itemClickListener?.onItemClicked(binding.radioEntity!!) }
        }

        fun bind(radioEntity: RadioEntity) = with(binding) {
            binding.radioEntity = radioEntity
            executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup?, itemClickListener: OnItemClickListener?): TrendingItemViewHolder {
                val trendingBinding = ItemTrendingBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                return TrendingItemViewHolder(trendingBinding, itemClickListener)
            }
        }
    }
}