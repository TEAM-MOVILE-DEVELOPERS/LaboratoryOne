package com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Types.NULL

@Entity(tableName = "table_dishes")
data class Dish(
	@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int ,
	@ColumnInfo val food_kind: String ,
	@ColumnInfo val dish_name: String ,
	@ColumnInfo val cook_name: String ,
	@ColumnInfo val price: String ,
	@ColumnInfo val preparation_time: String
) : Serializable {
	constructor() : this(NULL , "" , "" , "" , "" , "")
}