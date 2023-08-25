package com.example.applemarket





import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


import com.example.applemarket.databinding.ActivityDetailPageBinding
import com.google.android.material.snackbar.Snackbar

class DetailPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPageBinding
    private var isLiked: Boolean = false
    lateinit var products : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.likeBtn.setOnClickListener {


            if (isLiked) {
                binding.likeBtn.setBackgroundResource(R.drawable.baseline_favorite_border_24)
                showSnackBarMessage("관심 목록에 제거됨.")


            } else {
                binding.likeBtn.setBackgroundResource(R.drawable.baseline_favorite_24)
                showSnackBarMessage("관심 목록에 추가되었습니다.")



            }
            isLiked = !isLiked


        }


        val img = intent.getIntExtra("IMAGE", R.drawable.ic_launcher_background)
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

    private fun showSnackBarMessage(message: String) {
        val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}



