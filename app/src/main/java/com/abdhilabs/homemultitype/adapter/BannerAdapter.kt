package com.abdhilabs.homemultitype.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.homemultitype.R
import com.abdhilabs.homemultitype.entity.Movie
import com.abdhilabs.homemultitype.utils.inflate
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cover_item.view.*
import java.lang.Exception

class BannerAdapter(private val context: Context, private val movie: ArrayList<Movie>) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(parent.inflate(R.layout.cover_item))
    }

    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        setImage(holder.itemBanner, movie[position].imageUrl, position)
    }

    private fun setImage(imageView: ImageView, imageUrl: String, position: Int) {
        Picasso.get().load(imageUrl).fit().centerCrop().into(imageView, object : Callback {
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                imageView.setBackgroundResource(R.drawable.ic_launcher_background)
            }
        })
        imageView.setOnClickListener {
            Toast.makeText(context, "Clicked: $position", Toast.LENGTH_SHORT).show()
        }
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemBanner = itemView.item_cover_picture as ImageView
    }

}