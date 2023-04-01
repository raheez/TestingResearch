package com.example.testingresearch

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest{
    private lateinit var resourceComparer : ResourceComparer

    @Before
    fun setup(){
        resourceComparer = ResourceComparer()
    }

    @After
    fun tearDown(){

    }

    @Test
    fun stringsAreEqual_returnTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.checkIfStringsAreEqual(context,R.string.app_name,"TestingResearch")
        assertThat(result).isTrue()
    }

    @Test
    fun stringsAreEqual_returnFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.checkIfStringsAreEqual(context,R.string.app_name,"TestingResearchhh")
        assertThat(result).isFalse()
    }


}