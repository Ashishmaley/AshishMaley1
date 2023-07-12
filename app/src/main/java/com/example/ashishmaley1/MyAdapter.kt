package com.example.ashishmaley1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ashishmaley1.databinding.ItemBinding
import com.squareup.picasso.Picasso

 class MyAdapter(private val context: Activity, private val arr: List<Meme>) :
    RecyclerView.Adapter<MyAdapter.MyViewholder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewholder(view, arr, context)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        val currentItem = arr[position]
        val count = currentItem.preview.size - 1
        Picasso.get().load(currentItem.preview[count]).into(holder.binding.image)
        holder.binding.status.text=currentItem.postLink
        holder.binding.Likes.text=currentItem.ups.toString()
        holder.binding.postComment.text=currentItem.title
        holder.binding.userName.text=currentItem.author
        holder.binding.smallImage.setImageResource(R.drawable.img_5)
    }

    inner class MyViewholder(itemView: View, arr: List<Meme>, context: Activity) :
        RecyclerView.ViewHolder(itemView) {
        val binding: ItemBinding = ItemBinding.bind(itemView)
        }
    }