package com.abdhilabs.homemultitype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.homemultitype.adapter.GroupAdapter
import com.abdhilabs.homemultitype.data.GroupItem
import com.abdhilabs.homemultitype.data.MovieItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var groupItem = GroupItem.list as ArrayList
    private var bannerItem = MovieItem.banner as ArrayList
    private var horizontalItem = MovieItem.horizontal as ArrayList
    private var verticalItem = MovieItem.vertical as ArrayList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterGroup = GroupAdapter(this, groupItem, bannerItem, horizontalItem, verticalItem)

        rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterGroup
        }
    }
}
