package com.example.basalam.view_model

import androidx.lifecycle.*
import com.example.basalam.api.ServerAPI
import com.example.basalam.data.QUERY
import com.example.basalam.model.Product
import com.example.basalam.model.ServerResult
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class MainViewModel(var serverAPI: ServerAPI) : ViewModel() {

    val errorLiveData = MutableLiveData<String>()

    var behaviorSubject = BehaviorSubject.create<Boolean>()

    fun loading(): BehaviorSubject<Boolean> = behaviorSubject

    var productsLiveData: LiveData<ServerResult> = liveData {
        behaviorSubject.onNext(true)
        try {
            val product = serverAPI.getProducts(QUERY)
            emit(product)
            behaviorSubject.onNext(false)
        } catch (e: Exception) {
            errorLiveData.value = e.message
        }
    }


}