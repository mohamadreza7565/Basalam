package com.example.basalam

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.basalam.adapters.ProductsRvAdapter
import com.example.basalam.api.ServerAPI
import com.example.basalam.app.RetrofitRequestOptions
import com.example.basalam.dao.UserDao
import com.example.basalam.data.QUERY
import com.example.basalam.database.AppDatabase
import com.example.basalam.model.Product
import com.example.basalam.model.ServerResult
import com.example.basalam.view_model.MainViewModel
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val context = this
    lateinit var userDao: UserDao
    lateinit var db : AppDatabase
    var mainViewModel = MainViewModel(RetrofitRequestOptions().getApi())
    var list: ArrayList<Product> = ArrayList()
    var disposable: CompositeDisposable? = null
    lateinit var adapter: ProductsRvAdapter
    var loadingType = "PROGRESS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv_products.layoutManager = GridLayoutManager(this,2)
        adapter = ProductsRvAdapter(this, list)
        rv_products.adapter = adapter

        // Get list of users

        initLoading()

        getProducts()
    }

    fun initLoading() {
        mainViewModel.loading()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Boolean> {
                override fun onSubscribe(d: Disposable) {
                    disposable?.add(d)
                }

                override fun onNext(t: Boolean) {
                    if (loadingType == "PROGRESS")
                        if (t) {
                            progress_bar.visibility = View.VISIBLE
                        } else {
                            progress_bar.visibility = View.GONE
                        }
                    else {
                        // DO ACTION
                    }
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })
    }

    private fun getProducts() {

        mainViewModel.productsLiveData.observe(context,{
            list.clear()
            list.addAll(it.data.productSearch.products)
            adapter.notifyDataSetChanged()
        })

        mainViewModel.errorLiveData.observe(context,{
            Toast.makeText(context,"خطا در برقراری ارتباط با سرور",Toast.LENGTH_SHORT).show()
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        if (disposable != null)
        // Dispose rxJava
            disposable?.clear()
    }

}