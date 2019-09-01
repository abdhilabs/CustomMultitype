package com.abdhilabs.homemultitype.data

import com.abdhilabs.homemultitype.entity.Movie

class MovieItem {
    companion object {
        val banner: List<Movie>
            get() = mutableListOf(
                    Movie("Banner1", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/cover_item_0.jpg"),
                    Movie("Banner2", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/cover_item_1.jpg"),
                    Movie("Banner3", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/cover_item_2.jpg")
            )
        val horizontal: List<Movie>
            get() = mutableListOf(
                    Movie("Horizonall", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_3.jpg"),
                    Movie("Horizonal2", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_4.jpg"),
                    Movie("Horizonal3", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_5.jpg"),
                    Movie("Horizonal4", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_6.jpg"),
                    Movie("Horizonal5", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_7.jpg")
            )
        val vertical: List<Movie>
            get() = mutableListOf(
                    Movie("Banner1", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_8.jpg"),
                    Movie("Banner2", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_9.jpg"),
                    Movie("Banner3", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_10.jpg"),
                    Movie("Banner3", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_11.jpg")
            )
    }
}