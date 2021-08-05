package com.example.basalam.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.basalam.R
import com.example.basalam.model.Product
import com.example.basalam.retrofit.ProductRetrofit.Companion.QUERY
import com.example.basalam.utils.DataState
import com.example.basalam.view.adapters.ProductsRvAdapter
import com.example.basalam.view_model.MainStateEvent
import com.example.basalam.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val context = this
    lateinit var adapter : ProductsRvAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv_products.layoutManager = GridLayoutManager(this,2)
        adapter = ProductsRvAdapter(this)
        rv_products.adapter = adapter


        subscribeObserver()
        viewModel.setStateEvent(MainStateEvent.GetMovieEvents,QUERY)

    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Product>> -> {
                    displayProgressBar(false)
                    initRv(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }

        })
    }

    private fun displayError(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Unknown error", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun initRv(movies: List<Product>) {
        adapter.replace(movies)
    }


}