package com.juancho1037.umadefoods.ui.home.cooks_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.CookCardBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.Cook

class CooksAdapter(
	private val cooksList: ArrayList<Cook> ,
	// Unit significa que Movie puede ser de cualquier tipo
	private val onItemClicked: (Cook) -> Unit
) : RecyclerView.Adapter<CooksAdapter.CookViewHolder>() {
	
	override fun onCreateViewHolder(
		parent: ViewGroup ,
		viewType: Int
	): CookViewHolder {
		val itemView =
			LayoutInflater.from(parent.context).inflate(R.layout.cook_card , parent , false)
		return CookViewHolder(itemView)
	}
	
	override fun onBindViewHolder(cookViewHolder: CookViewHolder , position: Int) {
		val cook = cooksList[position]
		cookViewHolder.bindCook(cook)
		cookViewHolder.itemView.setOnClickListener { onItemClicked(cooksList[position]) }
	}
	
	override fun getItemCount(): Int = cooksList.size
	
	fun appendItems(newList: ArrayList<Cook>) {
		// Para pedirle al backend que envíe listas nuevas
		cooksList.clear()
		cooksList.addAll(newList)
		notifyDataSetChanged()
	}
	
	class CookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private val cookCardBinding = CookCardBinding.bind(itemView)
		fun bindCook(cook: Cook) {
			with(cookCardBinding) {
				rankTextView.text = cook.rank
				nameChefTextView.text = cook.cook_name
				typeDish.text = cook.food_kind
				LocationTextView.text = cook.location
			}
		}
	}
}