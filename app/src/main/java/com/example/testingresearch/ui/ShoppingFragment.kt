package com.example.testingresearch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testingresearch.databinding.ShoppingFragmentBinding

class ShoppingFragment : Fragment() {

    private lateinit var shoppingFragmentBinding: ShoppingFragmentBinding
    val viewModel  by viewModels<ShoppingViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoppingFragmentBinding = ShoppingFragmentBinding.inflate(layoutInflater)
        return shoppingFragmentBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}