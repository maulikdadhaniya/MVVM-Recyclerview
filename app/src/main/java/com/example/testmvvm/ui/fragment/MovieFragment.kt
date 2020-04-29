package com.example.testmvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmvvm.R
import com.example.testmvvm.ui.adapter.MoviesAdapter
import com.example.testmvvm.clicklistner.RecyclerViewClickListener
import com.example.testmvvm.repo.MovieRepository
import com.example.testmvvm.response.OData
import com.example.testmvvm.retrofit.MoviesAPI
import kotlinx.android.synthetic.main.movie_fragment.*


class MovieFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MoviesAPI()
        val repository = MovieRepository(api)
        factory = MovieViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(requireContext(), movies, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: OData) {
        when (view.id) {
            R.id.button_book -> {
                Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "Like Layout Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }


}
