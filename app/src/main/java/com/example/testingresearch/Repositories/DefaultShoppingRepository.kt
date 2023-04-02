package com.example.testingresearch.Repositories

import androidx.lifecycle.LiveData
import com.example.testingresearch.data.local.ShoppingDao
import com.example.testingresearch.data.local.ShoppingItem
import com.example.testingresearch.data.remote.PixabayAPI
import com.example.testingresearch.data.remote.responses.ImageResponse
import com.example.testingresearch.utils.Resource
import javax.inject.Inject

class DefaultShoppingRepository
    @Inject constructor(
        private val shoppingDao: ShoppingDao,
        private val pixabayApi : PixabayAPI
    ) : ShoppingRepository{

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)

    }

    override fun observeAllShoppingItem(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItem()

    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayApi.searchForImage(imageQuery)
            if (response.isSuccessful){
                response?.body()?.let {
                    return Resource.success(it)
                } ?: Resource.error("An unknown error occured",null)

            }else{
                Resource.error("An unknown error occured",null)
            }
        }catch (e :Exception){

            Resource.error("couldn't reach the server",null)
        }
    }

}