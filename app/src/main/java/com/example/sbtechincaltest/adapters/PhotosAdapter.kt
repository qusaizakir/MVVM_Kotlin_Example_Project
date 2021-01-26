package com.example.sbtechincaltest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.sbtechincaltest.R
import com.example.sbtechincaltest.model.Photo
import com.example.sbtechincaltest.utils.toGlideUrlWithAgent
import kotlinx.android.synthetic.main.photo_item.view.*


class PhotosAdapter(private val context: Context, private val dataList: MutableList<Photo> = mutableListOf()) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        dataList[position].run {
            Glide
                .with(context)
                .load(thumbnailUrl.toGlideUrlWithAgent())
                .centerCrop()
                .into(holder.itemView.photo_item_image)

            holder.itemView.photo_item_text.text = title
        }
    }

    override fun getItemCount() = dataList.size

    fun updateData(newList: List<Photo>){
        this.dataList.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }

}