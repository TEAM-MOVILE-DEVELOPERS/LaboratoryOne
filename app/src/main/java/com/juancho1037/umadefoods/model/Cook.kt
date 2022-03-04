package com.juancho1037.umadefoods.model

import java.io.Serializable
import java.net.Inet4Address
// los data class no necesitan getters para acceder a la info
data class Cook(
	val name: String,
	val email: String,
	val address: String,
	val password: String, // para cambiar
) : Serializable // Para mandar en conjunto al siguiente fragmento
