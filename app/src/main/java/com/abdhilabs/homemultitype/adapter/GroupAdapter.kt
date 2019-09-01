package com.abdhilabs.homemultitype.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.homemultitype.R
import com.abdhilabs.homemultitype.entity.Group
import com.abdhilabs.homemultitype.entity.Movie
import com.abdhilabs.homemultitype.utils.inflate
import kotlinx.android.synthetic.main.group_item.view.*

class GroupAdapter(private val context: Context, private val group: ArrayList<Group>, private val banner: ArrayList<Movie>, private val horizontal: ArrayList<Movie>, private val vertical: ArrayList<Movie>)
    : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(parent.inflate(R.layout.group_item))
    }

    override fun getItemCount(): Int = group.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        setGroupTitle(holder.groupTitle, group[position].groupTitle)
        setGroupBtnTitle(holder.viewAll, group[position].groupBtn)
        setList(holder.groupRv, position)
    }

    private fun setGroupTitle(textView: TextView, text: String) {
        textView.text = text
    }

    private fun setGroupBtnTitle(button: Button, text: String) {
        button.text = text
        button.setOnClickListener {
            Toast.makeText(context, "You found me :)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setList(recyclerView: RecyclerView, position: Int) {
        when (position) {
            0 -> setBannerList(recyclerView)
            1 -> setHorizontal(recyclerView)
            2 -> setVertical(recyclerView)
        }
    }

    private fun setBannerList(recyclerView: RecyclerView) {
        val bannerAdapter = BannerAdapter(context, banner)
        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bannerAdapter
            isNestedScrollingEnabled = true
        }
    }

    private fun setHorizontal(recyclerView: RecyclerView) {
        val horizontalAdapter = HorizontalAdapter(context, horizontal)
        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = horizontalAdapter
            isNestedScrollingEnabled = true
        }
    }

    private fun setVertical(recyclerView: RecyclerView) {
        val verticalAdapter = VerticalAdapter(context, vertical)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = verticalAdapter
            isNestedScrollingEnabled = true
        }
    }

    class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val head_parent = itemView.head_parent as RelativeLayout
        val groupTitle = itemView.group_title as TextView
        val viewAll = itemView.view_all as Button
        val groupRv = itemView.group_recycler_view as RecyclerView
    }
}