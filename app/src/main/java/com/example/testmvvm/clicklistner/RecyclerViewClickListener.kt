package com.example.testmvvm.clicklistner

import android.view.View
import com.example.testmvvm.response.OData

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: OData)
}