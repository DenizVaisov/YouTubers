package com.example.kmmapp.bloggers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kmmapp.androidApp.MainActivity
import com.example.kmmapp.androidApp.R

class BloggerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blogger_info)
        getBloggerInfo(BloggerActivity().bloggers)
    }

    fun setImageURL(blogger: Blogger, imageView: ImageView) {
        val imgUrl: String = intent.getStringExtra("image-url").toString()
        val media = blogger.imageURL
        Glide.with(this)
            .load(imgUrl)
            .into(imageView)
    }

    fun getBloggerInfo(bloggers: MutableList<Blogger>){
        val nick: String = intent.getStringExtra("nickName").toString()

        val imageView: ImageView =     findViewById(R.id.blogger_img_info)
        val nickName: TextView =      findViewById(R.id.blogger_nick_name_info)
        val realName: TextView =      findViewById(R.id.blogger_real_name_info)
        val age: TextView =           findViewById(R.id.blogger_age_info)
        val description: TextView =   findViewById(R.id.blogger_description_info)

        for (blogger : Blogger in bloggers) {
            setImageURL(blogger, imageView)
            nickName.text = nick
            realName.text = blogger.realName
            age.text = blogger.age.toString()
            description.text = blogger.description
        }
    }
}