package com.example.testingresearch.Repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testingresearch.data.local.ShoppingItem
import com.example.testingresearch.data.remote.responses.ImageResponse
import com.example.testingresearch.utils.Resource
import com.example.testingresearch.utils.Status

class FakeShoppingRepositories : ShoppingRepository {

    private val shoppingItems = mutableListOf<ShoppingItem>()
    private val observableShoppingItem = MutableLiveData<List<ShoppingItem>>(shoppingItems)
    private val observableTotalPrice = MutableLiveData<Float>()

    private var shouldReturnNetworkError = false

    fun shouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    private fun refreshLiveData() {
        observableShoppingItem.postValue(shoppingItems)
        observableTotalPrice.postValue(getTotalPrice())
        observeTotalPrice()
    }

    private fun getTotalPrice(): Float? {
       return shoppingItems.sumByDouble { it.price.toDouble() }.toFloat()
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
        refreshLiveData()
    }


    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.remove(shoppingItem)
        refreshLiveData()
    }

    override fun observeAllShoppingItem(): LiveData<List<ShoppingItem>> {
        return observableShoppingItem
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return observableTotalPrice
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {

        if (shouldReturnNetworkError){
            return Resource.error("error occured",null)
        }else{
            return Resource.success(ImageResponse(listOf(),0,0))
        }
    }
}