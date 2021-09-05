package com.davidnardya.flickrgalleryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.davidnardya.flickrgalleryapp.R
import com.davidnardya.flickrgalleryapp.databinding.ActivityFullImageBinding
import kotlinx.android.synthetic.main.activity_full_image.*

class FullImageActivity : AppCompatActivity() {

    //Properties
    private lateinit var binding: ActivityFullImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPage()
    }

    private fun initPage() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_full_image)

        val imageUrl = intent.getStringExtra("imageUrl")

        Glide.with(full_image_view)
            .load(imageUrl)
            .into(full_image_view)

    }
}