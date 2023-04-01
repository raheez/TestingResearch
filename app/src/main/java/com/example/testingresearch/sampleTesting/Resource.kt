package com.example.testingresearch

import android.content.Context

class ResourceComparer {

    fun checkIfStringsAreEqual(context :Context,resId : Int,string: String) :Boolean {
        return context.getString(resId).equals(string)
    }
}