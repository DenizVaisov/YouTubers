package com.example.kmmapp.bloggers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kmmapp.androidApp.R

class BloggerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(blogger: Blogger) {
        setImageURL(blogger, itemView)
        nickName.text = blogger.nickName
//        realName.text = blogger.realName
//        age.text = blogger.age.toString()
//        description.text = blogger.description
    }

    fun setImageURL(blogger: Blogger, itemView: View) {
        val media = blogger.imageURL
        Glide.with(itemView)
            .load(media)
            .into(imageURL)
    }

    var imageURL: ImageView =      itemView.findViewById(R.id.blogger_img)
    var nickName: TextView =    itemView.findViewById(R.id.blogger_nick_name)
//    var realName: TextView =    itemView.findViewById(R.id.blogger_real_name)
//    var age: TextView =         itemView.findViewById(R.id.blogger_age)
//    var description: TextView = itemView.findViewById(R.id.blogger_description)
}