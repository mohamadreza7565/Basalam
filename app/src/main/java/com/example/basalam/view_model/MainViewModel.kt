package com.example.basalam.view_model


import androidx.lifecycle.*
import com.example.basalam.model.Product
import com.example.basalam.repository.MainRepository
import com.example.basalam.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val mainRepository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Product>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Product>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent, query: String) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetProductEvents -> {
                    mainRepository.getProducts(query)
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }.launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {
                    // who cares
                }
            }
        }
    }

}

sealed class MainStateEvent {
    object GetProductEvents : MainStateEvent()

    object None : MainStateEvent()
}