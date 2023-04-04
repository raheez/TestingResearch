package com.example.testingresearch.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testingresearch.Repositories.FakeShoppingRepositories
import org.junit.After
import org.junit.Assert.*
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
    fun
}