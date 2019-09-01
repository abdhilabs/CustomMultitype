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
import kotlinx.android.synthetic.main.horizontal_item.view.*
import java.lang.Exception

class HorizontalAdapter(private val context: Context, private val movie: ArrayList<Movie>) : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return HorizontalViewHolder(parent.inflate(R.layout.horizontal_item))
    }

    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        setImage(holder.imgHorizontal, movie[position].imageUrl, position)
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

    class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgHorizontal = itemView.item_horizontal_picture as ImageView
    }
}