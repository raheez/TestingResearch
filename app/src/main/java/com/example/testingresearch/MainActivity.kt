package com.example.testingresearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testingresearch.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        var str = buildString {
            for (i in 1..Constants.MAX_NAME_LENGTH+1){
                append(1)
            }
        }
        Log.d("main_Activity",""+str)
    }
}