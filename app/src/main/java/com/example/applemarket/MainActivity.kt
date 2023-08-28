package com.example.applemarket


import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val items: MutableList<Product> = mutableListOf()
    private lateinit var rvAdapter: RVAdapter

    companion object {
        const val DETAIL_PAGE_REQUEST_CODE = 123

    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.notificationArea.setOnClickListener {
            notification()
        }
        setContentView(binding.root)

        items.addAll(ProductList.items)

        rvAdapter = RVAdapter(items, object : RVAdapter.OnItemClickListener {
            override fun onItemClick(
                imageResourceId: Int,
                productName: String,
                productDescription: String,
                seller: String,
                price: String,
                address: String,
                position: Int

            ) {
                val intent = Intent(this@MainActivity, DetailPageActivity::class.java)
                intent.putExtra("IMAGE", imageResourceId)
                intent.putExtra("NAME", productName)
                intent.putExtra("DESCRIP", productDescription)
                intent.putExtra("SELLER", seller)
                intent.putExtra("PRICE", price)
                intent.putExtra("ADDRESS", address)
                intent.putExtra("POSITION", position)

                startActivityForResult(intent, DETAIL_PAGE_REQUEST_CODE)

            }


        }
        )

        rvAdapter.setOnItemLongClickListener(object : RVAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int) {
                showDeleteConfirmationDialog(position)
            }
        }

        )


        binding.RVArea.layoutManager = LinearLayoutManager(this)
        binding.RVArea.adapter = rvAdapter
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        binding.RVArea.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 && binding.floatingBtn.visibility != View.VISIBLE) {
                    binding.floatingBtn.show()
                    binding.floatingBtn.startAnimation(fadeIn)
                } else if (dy < 0 && binding.floatingBtn.visibility == View.VISIBLE) {
                    binding.floatingBtn.hide()
                    binding.floatingBtn.startAnimation(fadeOut)
                }
            }
        })
        binding.floatingBtn.setOnClickListener {
            scrollToTop()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == DETAIL_PAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            val position = data?.getIntExtra("POSITION", -1)
            val likeCount = data?.getIntExtra("LIKE_COUNT", 0)
            val isLiked = data?.getBooleanExtra("IS_LIKED", false)

            if (position != -1) {

                val product = items[position!!]
                product.like = likeCount!!
                product.isLiked = isLiked!!

                rvAdapter.notifyDataSetChanged()

            }
        }
    }

    private fun showDeleteConfirmationDialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("상품 삭제")
        builder.setIcon(R.drawable.back)
        builder.setMessage("상품을 정말로 삭제하시겠습니까?")
        builder.setPositiveButton("확인") { dialog, which ->


            rvAdapter.removeItem(position)
            rvAdapter.notifyDataSetChanged()

        }
        builder.setNegativeButton("취소") { dialog, which ->

            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }


    fun scrollToTop() {
        binding.RVArea.smoothScrollToPosition(0)
    }

    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelId = "one-channel"
            val channelName = "당근마케떠"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {

                description = "클론코딩당근마켓입니다"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }

            manager.createNotificationChannel(channel)


            builder = NotificationCompat.Builder(this, channelId)

        } else {

            builder = NotificationCompat.Builder(this)
        }

        val bitmap =
            BitmapFactory.decodeResource(resources, R.drawable.baseline_notifications_none_24)
        val intent = Intent(this, SampleActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        builder.run {
            setSmallIcon(R.drawable.baseline_notifications_none_24)
            setWhen(System.currentTimeMillis())
            setContentTitle("감자마케또")
            setContentText("키워드 알림\n설정한 키워드에 대한 알림이 도착했습니다!!!!!!!!")

            setLargeIcon(bitmap)

            addAction(R.drawable.baseline_notifications_none_24, "Action", pendingIntent)
        }

        manager.notify(11, builder.build())
    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("종료")
        builder.setIcon(R.drawable.back)
        builder.setMessage("정말  종료하시겠습니까?")
        builder.setPositiveButton("확인", { dialog, which ->

            finish()
        })
        builder.setNegativeButton("취소", { dialog, which ->

            dialog.dismiss()
        })
        val dialog = builder.create()
        dialog.show()
    }
}
