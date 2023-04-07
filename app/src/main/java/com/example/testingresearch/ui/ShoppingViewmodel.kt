package com.example.testingresearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingresearch.Repositories.ShoppingRepository
import com.example.testingresearch.data.local.ShoppingItem
import com.example.testingresearch.data.remote.responses.ImageResponse
import com.example.testingresearch.utils.Constants
import com.example.testingresearch.utils.Event
import com.example.testingresearch.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewmodel @Inject  constructor(
    private val repository : ShoppingRepository
) :ViewModel() {


    val shoppingItem = repository.observeAllShoppingItem()

    val totalPrice = repository.observeTotalPrice()


    private  val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val images :LiveData<Event<Resource<ImageResponse>>> = _images

    private  val _currentImageUrl = MutableLiveData<String>()
    val currentImageUrl :LiveData<String> = _currentImageUrl

    private  val _insertShoppingItemStatus = MutableLiveData<Event<Resource<ShoppingItem>>>()
    val insertShoppingItemStatus : MutableLiveData<Event<Resource<ShoppingItem>>> = _insertShoppingItemStatus

    fun setCurImageUrl(url:String){
        _currentImageUrl.postValue(url)
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertShoppingItemIntoDb(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun insertShoppingItem(name:String,amountString : String,priceString :String){
        if (name.isEmpty()||amountString.isEmpty()||priceString.isEmpty()){
            _insertShoppingItemStatus.postValue(Event(Resource.error("the fields must not be empty",null)))
            return
        }
        if (name.length > Constants.MAX_NAME_LENGTH){
            _insertShoppingItemStatus.postValue(Event(Resource.error("the name of the item " +
                    "must not exceed ${Constants.MAX_NAME_LENGTH} characters",null)))
            return
        }

        if (priceString.length > Constants.MAX_PRICE_LENGTH){
            _insertShoppingItemStatus.postValue(Event(Resource.error("the price of the item " +
                    "must not exceed ${Constants.MAX_PRICE_LENGTH} characters",null)))
            return
        }

        val amount = try {
            amountString.toInt()
        }
        catch (e:java.lang.Exception){
            _insertShoppingItemStatus.postValue(Event(Resource.error("please enter a valid amount",null)))
            return
        }

        val shoppingItem = ShoppingItem(name,amount,priceString.toFloat(),_currentImageUrl.value?:"")
        insertShoppingItemIntoDb(shoppingItem)
        setCurImageUrl("")
        _insertShoppingItemStatus.postValue(Event(Resource.success(data = shoppingItem)))
    }

    fun searchForImage(imageQuery :String){
        if (imageQuery.isEmpty()){
            return
        }
        _images.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = repository.searchForImage(imageQuery)
            _images.value = Event(response)
        }
    }
}