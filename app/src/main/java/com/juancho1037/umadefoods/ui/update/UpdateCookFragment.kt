 package com.juancho1037.umadefoods.ui.update

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.FragmentUpdateCookBinding

 class UpdateCookFragment : Fragment() {

    companion object {
        fun newInstance() = UpdateCookFragment()
    }

    private lateinit var updateCookBinding: FragmentUpdateCookBinding
    private lateinit var updateCookviewModel: UpdateCookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        updateCookBinding = FragmentUpdateCookBinding.inflate(inflater, container, false)
        updateCookviewModel = ViewModelProvider(this)[UpdateCookViewModel::class.java]
        return updateCookBinding.root
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)



     }

}