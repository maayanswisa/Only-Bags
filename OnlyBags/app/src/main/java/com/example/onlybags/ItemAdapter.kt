package com.example.onlybags

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlybags.databinding.ItemLayoutBinding

class ItemAdapter(val items: List<Item>, val callBack: ItemListener) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    interface ItemListener {
        fun onItemClicked(index: Int)
        fun onItemLongClicked(index: Int)
    }

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener, View.OnLongClickListener {

        init {
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }
        override fun onClick(v: View?) {
            callBack.onItemClicked(adapterPosition)
        }
        override fun onLongClick(v: View?): Boolean {
            callBack.onItemLongClicked(adapterPosition)
            return true
        }
        fun bind(item: Item) {
            binding.itemTitle.text = item.title
            binding.itemDescription.text = item.description
            binding.itemSize.text = item.size.toString()
            binding.itemPrice.text = item.price.toString()
            binding.cardView.setCardBackgroundColor(item.backgroundColor)


            // קטע נוסף: שימוש ב-Glide
            Glide.with(binding.root)
                .load(item.photo)
                .placeholder(R.drawable.pic11) // תמונה חילופית כל עוד התמונה טוענת
                .error(R.drawable.logo) // תמונת שגיאה במקרה של תמונה לא תקינה
                .into(binding.itemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}
