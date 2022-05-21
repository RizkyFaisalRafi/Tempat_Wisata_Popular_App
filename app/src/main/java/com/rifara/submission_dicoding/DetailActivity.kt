package com.rifara.submission_dicoding

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var tvDetailName: TextView
    private lateinit var tvDetailsource: TextView
    private lateinit var tvDetailAbout: TextView
    private lateinit var imgDetailImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tvDetailName = findViewById(R.id.tv_detail_name)
        tvDetailsource = findViewById(R.id.tv_source)
        tvDetailAbout = findViewById(R.id.tv_detail_about)
        imgDetailImg = findViewById(R.id.img_detail_img)

        intent?.let {
            getExtraDetail()
        }
    }

    private fun getExtraDetail() {
        tvDetailName.text = intent.getStringExtra(EXTRA_NAME)
        title = intent.getStringExtra(EXTRA_NAME)
        tvDetailsource.text = intent.getStringExtra(EXTRA_SOURCE)
        tvDetailAbout.text = intent.getStringExtra(EXTRA_DETAIL)
        val getImg = intent.getIntExtra(EXTRA_IMG, 0)
        Glide.with(this)
            .load(getImg)
            .into(imgDetailImg)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_SOURCE = "extra_source"
    }
}