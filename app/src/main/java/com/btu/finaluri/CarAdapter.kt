package com.btu.finaluri

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.btu.finaluri.R
import com.bumptech.glide.Glide


class CarAdapter(private val carsList : ArrayList<Cars>) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.list_item),
            parent,false)
        return CarViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {

        val currentItem = carsList[position]
        Glide.with(holder.imageCar.context)
            .load(currentItem.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageCar)

        holder.name.text = currentItem.name
        holder.price.text = currentItem.price


    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    class CarViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageCar: ImageView = itemView.findViewById(R.id.imageCar)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}