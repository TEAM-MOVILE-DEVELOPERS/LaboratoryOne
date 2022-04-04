package com.juancho1037.umadefoods.utils

enum class Status {
    Success{
        override fun toString(): String{
            return this.name
        }
    },
    Error {
        override fun toString(): String{
            return this.name
        }
    },
    Loading{
        override fun toString(): String{
            return this.name
        }
    }
}