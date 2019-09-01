package com.abdhilabs.homemultitype.data

import com.abdhilabs.homemultitype.entity.Group

class GroupItem {

    companion object {
        val list: List<Group>
            get() = mutableListOf(
                    Group("Banner", "View All"),
                    Group("Horizontal", "View All"),
                    Group("Vertical", "View All")
            )
    }
}