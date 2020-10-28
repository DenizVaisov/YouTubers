package com.example.kmmapp.bloggers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kmmapp.androidApp.R

class BloggerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blogger_info)
        getBloggerInfo()
    }

    fun setImageURL(blogger: Blogger, imageView: ImageView) {
        val media = blogger.imageURL

        Glide.with(this)
            .load(media)
            .into(imageView)
    }

    @SuppressLint("SetTextI18n")
    fun getBloggerInfo(){
        val bloggers = intent.getSerializableExtra("bloggers") as Blogger

        val imageView: ImageView =    findViewById(R.id.blogger_img_info)
        val nickName: TextView =      findViewById(R.id.blogger_nick_name_info)
        val realName: TextView =      findViewById(R.id.blogger_real_name_info)
        val age: TextView =           findViewById(R.id.blogger_age_info)
        val description: TextView =   findViewById(R.id.blogger_description_info)

        setImageURL(bloggers, imageView)
        nickName.text = "Псевдоним:" + "\n" + bloggers.nickName
        realName.text = "Имя:" + "\n" + bloggers.realName
        age.text = "Возвраст:" + "\n" + bloggers.age.toString() + " лет"
        description.text = "Биография:" + "\n" + bloggers.description
    }
}

