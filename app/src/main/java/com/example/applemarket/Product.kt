package com.example.applemarket


data class Product(

    val imageResourceId: Int,
    val productName: String,
    val productDescription: String,
    val seller: String,
    val price: String,
    val address: String,
    val review: Int,
    val like: Int
)
