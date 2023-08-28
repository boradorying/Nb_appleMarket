package com.example.applemarket

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.RvItemsBinding

class RVAdapter(private var items: MutableList<Product>,private val onItemClickListener: OnItemClickListener,private var onItemLongClickListener: OnItemLongClickListener? = null) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {


    interface OnItemLongClickListener{
        fun onItemLongClick(position: Int)
    }

    interface OnItemClickListener {
        fun onItemClick(imageResourceId: Int, productName: String, productDescription: String, seller: String, price: String, address: String,position: Int)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val binding = RvItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        Log.d("jun","$position")
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun setOnItemLongClickListener(listener: OnItemLongClickListener) {
        this.onItemLongClickListener = listener
    }
    fun removeItem(position: Int) {
        if (position >= 0 && position < items.size) {
            items.removeAt(position)


            for (i in position until items.size) {
                items[i].position = i
            }

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size - position)
        }
    }



    inner class ViewHolder(private val binding: RvItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnLongClickListener {
                onItemLongClickListener?.onItemLongClick(adapterPosition)
                true
            }
        }
        fun bindItems(item: Product) {
            binding.productImgArea.setImageResource(item.imageResourceId)
            binding.productNameArea.text = item.productName
            binding.locationArea.text = item.address
            binding.priceArea.text = item.price
            binding.iconArea.setImageResource(R.drawable.baseline_reviews_24)

            if (item.isLiked) {

                binding.iconArea2.setImageResource(R.drawable.baseline_favorite_24)
            } else {
                binding.iconArea2.setImageResource(R.drawable.baseline_favorite_border_24)
            }
            Log.d("jun","$item")
            binding.reviewArea.text = item.review.toString()
            binding.likeArea.text = item.like.toString()

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(
                    item.imageResourceId,
                    item.productName,
                    item.productDescription,
                    item.seller,
                    item.price,
                    item.address,
                    item.position,

                )
            }
        }
    }
}
