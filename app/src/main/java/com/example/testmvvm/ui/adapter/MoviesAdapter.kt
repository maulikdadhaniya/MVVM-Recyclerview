package com.example.testmvvm.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmvvm.R
import com.example.testmvvm.clicklistner.RecyclerViewClickListener
import com.example.testmvvm.response.MovieResponse
import kotlinx.android.synthetic.main.recyclerview_movie.view.*


class MoviesAdapter(
    private val context: Context,
    private val items: MovieResponse,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = items.o_data[position].name
        holder.gam.text = items.o_data[position].gam
        holder.address.text = items.o_data[position].address

        Glide.with(context)
            .load(items.o_data[position].photo)
            .into(holder.imageView)
        holder.button_book.setOnClickListener {

            listener.onRecyclerViewItemClick(
                holder.button_book,
                items.o_data[position]
            )
        }
    }


    override fun getItemCount(): Int {
        return items.o_data.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.imageView!!
        val name = view.textViewTitle!!
        val gam = view.textViewLanguage!!
        val address = view.textViewType!!
        val button_book = view.button_book

    }

}