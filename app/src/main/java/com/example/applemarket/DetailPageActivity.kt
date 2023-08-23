package com.example.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applemarket.databinding.ActivityDetailPageBinding

class DetailPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val img = intent.getIntExtra("IMAGE",R.drawable.ic_launcher_background)
        val productName = intent.getStringExtra("NAME")
        val productDescription = intent.getStringExtra("DESCRIP")
        val seller = intent.getStringExtra("SELLER")
        val price = intent.getStringExtra("PRICE")
        val address = intent.getStringExtra("ADDRESS")


        binding.imgArea.setImageResource(img)
        binding.descriptionArea.text = productDescription
        binding.productNameArea2.text = productName
        binding.nameArea2.text = seller
        binding.priceArea2.text = price
        binding.locationArea2.text = address
    }
}