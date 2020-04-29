package com.example.testmvvm.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testmvvm.repo.MovieRepository
import com.example.testmvvm.response.MovieResponse
import com.example.testmvvm.utils.Coroutines
import kotlinx.coroutines.Job

class MovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private lateinit var job: Job
    private val _moviesMutableLiveData = MutableLiveData<MovieResponse>()

    val movies: LiveData<MovieResponse>
        get() = _moviesMutableLiveData

     fun getMovies() {

        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _moviesMutableLiveData.value = it }

        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
