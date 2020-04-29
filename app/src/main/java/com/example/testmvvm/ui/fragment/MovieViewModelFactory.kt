package com.example.testmvvm.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testmvvm.repo.MovieRepository

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(
    private val repo: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repo) as T
    }
}