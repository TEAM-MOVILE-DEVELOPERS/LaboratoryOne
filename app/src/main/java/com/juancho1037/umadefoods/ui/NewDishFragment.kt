package com.juancho1037.umadefoods.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.R

class NewDishFragment : Fragment() {

    companion object {
        fun newInstance() = NewDishFragment()
    }

    private lateinit var viewModel: NewDishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_dish, container, false)
    }
}