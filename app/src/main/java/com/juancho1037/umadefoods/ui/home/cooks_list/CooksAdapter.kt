package com.juancho1037.umadefoods.ui.home.cooks_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.CookCardBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.Cook

class CooksAdapter(
    private val cooksList: ArrayList<Cook>
):RecyclerView.Adapter<CooksAdapter.CooksViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CooksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cook_card,parent,false)
        return CooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: CooksViewHolder, position: Int) {
        val cook = cooksList[position]
        holder.bind(cook)
    }

    override fun getItemCount(): Int = cooksList.size

    fun appendItems(newList: ArrayList<Cook>){
        cooksList.clear()
        cooksList.addAll(newList)
        notifyDataSetChanged()
    }

    class CooksViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = CookCardBinding.bind(itemView)
        fun bind(cook: Cook){
            with(binding){
                rankeTextView.text = cook.rank
                nameChefTextView.text = cook.cook_name
                typeDish.text = cook.food_kind
                LocationTextView.text = cook.location
            }
        }
    }
}