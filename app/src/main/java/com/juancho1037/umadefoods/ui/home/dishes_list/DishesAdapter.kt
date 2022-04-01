package com.juancho1037.umadefoods.ui.home.dishes_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.DishCardBinding
import com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes.Dish

class DishesAdapter(
    private val dishesList: ArrayList<Dish> ,
    private val onItemClicked: (Dish) -> Unit
) : RecyclerView.Adapter<DishesAdapter.DishesViewHolder>() {
    
    override fun onCreateViewHolder(
        parent: ViewGroup ,
        viewType: Int
    ): DishesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.dish_card , parent , false)
        return DishesViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: DishesViewHolder , position: Int) {
        val dish = dishesList[position]
        holder.bind(dish)
        holder.itemView.setOnClickListener {
            onItemClicked(dishesList[position])
        }
    }
    
    override fun getItemCount(): Int = dishesList.size
    
    fun appendItems(newList: ArrayList<Dish>) {
        dishesList.clear()
        dishesList.addAll(newList)
        notifyDataSetChanged()
    }

    class DishesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = DishCardBinding.bind(itemView)
        fun bind(dish: Dish) {
            with(binding){
                typeDishTextview.text = dish.food_kind
                nameTextview.text = dish.dish_name
                madeTextview.text = dish.cook_name
                priceTextview.text = dish.price
                timePreparationTextview.text = dish.preparation_time
            }
        }
    }
}