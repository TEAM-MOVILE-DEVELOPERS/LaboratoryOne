package com.juancho1037.umadefoods.ui.delete

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.databinding.FragmentDeleteDishBinding

class DeleteDishFragment : Fragment() {

    private lateinit var deleteBinding: FragmentDeleteDishBinding
    private lateinit var deleteDishViewModel: DeleteDishViewModel

    companion object {
        fun newInstance() = DeleteDishFragment()
    }

    private lateinit var dishViewModel: DeleteDishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        deleteBinding = FragmentDeleteDishBinding.inflate(inflater, container, false)
        deleteDishViewModel = ViewModelProvider(this)[DeleteDishViewModel::class.java]
        return deleteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: Implementacion de observers para eliminar platillos
/*        deleteDishViewModel.findBookDone.observe(viewLifecycleOwner, { result ->
            onFindBookDoneSubscribe(result)
        })

        with(deleteBinding) {
            searchButton.setOnClickListener {
                deleteDishViewModel.searchBook(nameEditText.text.toString())
            }
        }*/
    }


}