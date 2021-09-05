package com.davidnardya.flickrgalleryapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.davidnardya.flickrgalleryapp.R
import com.davidnardya.flickrgalleryapp.activities.FullImageActivity
import com.davidnardya.flickrgalleryapp.model.Image

class RecyclerViewAdapter(
    private val context: Context
) : PagingDataAdapter<Image, RecyclerViewAdapter.ViewHolder>(DiffUtilCallback()) {

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
            val farmId = it.farm
            val serverId = it.server
            val imageId = it.id
            val secret = it.secret
            val url = "https://farm${farmId}.staticflickr.com/${serverId}/${imageId}_${secret}.jpg"
            holder.itemView.setOnClickListener {

                val intent = Intent(context, FullImageActivity::class.java)
                intent.putExtra("imageUrl", url)
                context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_custom_recycler_item, parent, false)

        return ViewHolder(inflater)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val imageView: ImageView = view.findViewById(R.id.row_image)

        fun bind(image: Image) {
            Glide.with(imageView)
                .load(image.url_s)
                .into(imageView)
        }
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.url_s == newItem.url_s
        }

    }
}