package com.example.kmmapp.bloggers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kmmapp.androidApp.R

 class BloggerActivity : AppCompatActivity(), BloggerClickListener {
     private lateinit var list: RecyclerView
     val bloggers = mutableListOf<Blogger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blogger)


        list = findViewById(R.id.list_recycler_view)
        bloggers.add(Blogger("https://www.tubefilter.com/wp-content/uploads/2020/02/pewdiepie-return-youtube.jpg", "PewDiePie", "Фе́ликс А́рвид У́льф Че́льберг", 30, ""))
        bloggers.add(Blogger("https://i.insider.com/5e453e6f96eee6567a49fbe2?width=896&format=jpeg", "JackSepticEye", "Шон Уильям МакЛоглин",30, ""))

        val adapter = BloggerAdapter(bloggers, this)
        list.layoutManager = GridLayoutManager(this, 2)
        list.adapter = adapter
    }

    override fun onBloggerClickListener(blogger: Blogger) {
        val intent = Intent(this, BloggerInfoActivity::class.java)
        intent.putExtra("image-url", blogger.imageURL)
        intent.putExtra("nickName", blogger.nickName)
        startActivity(intent)
    }
}