package com.example.testingresearch.Repositories

import androidx.lifecycle.LiveData
import com.example.testingresearch.data.local.ShoppingItem
import com.example.testingresearch.data.remote.responses.ImageResponse
import com.example.testingresearch.utils.Resource
import retrofit2.Response
import retrofit2.http.Query

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItem(): LiveData<List<ShoppingItem>>
    fun observeTotalPrice(): LiveData<Float>
    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>



}