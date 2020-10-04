package com.example.kmmapp.bloggers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kmmapp.androidApp.R

class BloggerAdapter (val bloggers : List<Blogger>, val bloggerClickListener: BloggerClickListener): RecyclerView.Adapter<BloggerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BloggerHolder {
        val context =  parent.context
        val inflater = LayoutInflater.from(context)
        val view =     inflater.inflate(R.layout.blogger_view, parent, false)
        return BloggerHolder(view)
    }

    override fun onBindViewHolder(holder: BloggerHolder, position: Int) {
        val blogger = bloggers[position]
        holder.bind(blogger)
        holder.itemView.setOnClickListener{
            bloggerClickListener.onBloggerClickListener(blogger)
        }
    }

    override fun getItemCount(): Int {
        return bloggers.size
    }
}