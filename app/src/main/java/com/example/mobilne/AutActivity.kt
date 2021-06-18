package com.example.mobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class AutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aut)

        var img1 = findViewById<ImageView>(R.id.imageAut1)
        var img2 = findViewById<ImageView>(R.id.imageAut2)

        Glide.with(this).load("https://orgonit.tk/kudłaty2.jpg").transition(DrawableTransitionOptions.withCrossFade()).into(img1);
        Glide.with(this).load("https://orgonit.tk/cthulu1.jpg").transition(DrawableTransitionOptions.withCrossFade()).into(img2);
    }
}