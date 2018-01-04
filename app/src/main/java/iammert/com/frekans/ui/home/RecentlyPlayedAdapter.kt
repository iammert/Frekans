package iammert.com.frekans.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import iammert.com.data.local.entity.RadioEntity
import iammert.com.frekans.databinding.ItemRecentlyPlayedBinding

/**
 * Created by mertsimsek on 03/01/2018.
 */
class RecentlyPlayedAdapter(private var recentlyPlayedRadios: List<RadioEntity> = ArrayList())
    : RecyclerView.Adapter<RecentlyPlayedAdapter.RecentlyPlayedItemViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClicked(radioEntity: RadioEntity)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun setRecentlyPlayedRadios(recentlyPlayedRadios: List<RadioEntity>) {
        this.recentlyPlayedRadios = recentlyPlayedRadios
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecentlyPlayedItemViewHolder
            = RecentlyPlayedItemViewHolder.create(parent, itemClickListener)

    override fun onBindViewHolder(holder: RecentlyPlayedItemViewHolder, position: Int)
            = holder.bind(recentlyPlayedRadios[position])

    override fun getItemCount() = recentlyPlayedRadios.size

    class RecentlyPlayedItemViewHolder(private var binding: ItemRecentlyPlayedBinding,
                                       private var itemClickListener: OnItemClickListener?) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { itemClickListener?.onItemClicked(binding.recentlyPlayedRadio!!) }
        }

        fun bind(recentlyPlayedRadio: RadioEntity) = with(binding) {
            binding.recentlyPlayedRadio = recentlyPlayedRadio
            executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup?, itemClickListener: OnItemClickListener?): RecentlyPlayedItemViewHolder {
                val recentlyPlayedBinding = ItemRecentlyPlayedBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                return RecentlyPlayedItemViewHolder(recentlyPlayedBinding, itemClickListener)
            }
        }
    }

}