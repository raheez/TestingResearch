package com.example.testingresearch.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testingresearch.Repositories.FakeShoppingRepositories
import com.example.testingresearch.getOrAwaitValueTest
import com.example.testingresearch.utils.Constants
import com.example.testingresearch.utils.Status
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShoppingViewmodelTest{

    private lateinit var viewmodel: ShoppingViewmodel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        viewmodel = ShoppingViewmodel(FakeShoppingRepositories())
    }

    @After
    fun tearDown(){
    }

    @Test
    fun `insert shopping item with empty field,return false`(){
        viewmodel.insertShoppingItem("name","","3.0")

        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()).isEqualTo(Status.ERROR)
    }
    @Test
    fun `insert shopping item with too long name,return false`(){

        val name = buildString{
            for (i in 1..Constants.MAX_NAME_LENGTH+1){
                append("1")
            }
        }
        viewmodel.insertShoppingItem(name,"","3.0")

        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }
    @Test
    fun `insert shopping item with high amount,return false`(){
        viewmodel.insertShoppingItem("name","999999999999999","3.0")
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }
    @Test
    fun `insert shopping item with valid input,return true`(){
        viewmodel.insertShoppingItem("name","5","3.0")
        val value = viewmodel.insertShoppingItemStatus.getOrAwaitValueTest()
        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }


}