package com.juancho1037.umadefoods.server.dishServer

data class DishServer(
    val food_kind: String? = null,
    val dish_name: String? = null,
    val cook_name: String? = null,
    val price: String? = null,
    val time_preparation:String? = null,
    val rank: String? = null,
    val description: String? = null,
    val proteins: String? = null,
    val carbohydrates: String? = null,
    val sodium: String? = null,
    val potassium: String? = null,
    val vitamins: String? = null,
    val calories: String? = null,
    val availability: String? = null,
    val portion_size: String? = null,
    val units: String? = null,
)
