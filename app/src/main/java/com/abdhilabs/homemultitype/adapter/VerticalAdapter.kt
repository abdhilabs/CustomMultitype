package com.abdhilabs.homemultitype.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.homemultitype.R
import com.abdhilabs.homemultitype.entity.Movie
import com.abdhilabs.homemultitype.utils.inflate
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.vertical_item.view.*

class VerticalAdapter(private val context: Context, private val movie: ArrayList<Movie>) : RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewHolder(parent.inflate(R.layout.vertical_item))
    }

    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        setTitle(holder.title, movie[position].title)
        setSubTitle(holder.subTitle, movie[position].title)
        setImage(holder.imgVertical, movie[position].imageUrl, position)
        setClick(holder.click, position)
    }

    private fun setClick(click: RelativeLayout, position: Int) {
        click.setOnClickListener {
            Toast.makeText(context, "You found me at $position", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setTitle(textView: TextView, title: String) {
        textView.text = title
    }

    private fun setSubTitle(textView: TextView, title: String) {
        textView.text = title
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

    class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgVertical = itemView.item_vertical_picture as ImageView
        val title = itemView.item_title as TextView
        val subTitle = itemView.item_subtitle as TextView
        val click = itemView.vertical_parent as RelativeLayout
    }
}