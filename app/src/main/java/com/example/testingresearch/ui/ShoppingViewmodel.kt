package com.example.testingresearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingresearch.Repositories.ShoppingRepository
import com.example.testingresearch.data.local.ShoppingItem
import com.example.testingresearch.data.remote.responses.ImageResponse
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

    }

    fun searchForImage(imageQuery :String){

    }




}