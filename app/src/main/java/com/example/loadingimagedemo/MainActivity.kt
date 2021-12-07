package com.example.loadingimagedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.RoundedCorner
import android.widget.ImageView
import coil.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)

        val image1 = "https://i.stack.imgur.com/ILTQq.png"
        val image2 = "https://w7.pngwing.com/pngs/915/345/png-transparent-multicolored-balloons-illustration-balloon-balloon-free-balloons-easter-egg-desktop-wallpaper-party-thumbnail.png"
        val image3 = "https://png.pngtree.com/png-clipart/20180626/ourmid/pngtree-instagram-icon-instagram-logo-png-image_3584853.png"

        // Coil

        imageView2.load(image2){
            crossfade(true)
            crossfade(2000)
//            transformations(RoundedCornersTransformation(30f)) // Rounded corners
//            transformations(CircleCropTransformation()) // Circle image boundary
//            transformations(GrayscaleTransformation()) // Black and white
//            transformations(BlurTransformation(this@MainActivity,10f)) // Blur Image
            transformations(CircleCropTransformation(),GrayscaleTransformation()) // Multiple properties can be set

        }

        // Image loading with Picasso

        Picasso.get()
            .load(image1)
//            .resize(50, 50)
//            .centerCrop()
            .into(imageView)

        // Image Loading with Glide

        Glide.with(this)
            .load(image3)
            .fitCenter()
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView3)
    }
}