package com.example.kmmapp.bloggers

import java.io.Serializable

data class Blogger (
    var imageURL: String,
    var nickName: String,
    var realName: String,
    var age: Int,
    var description: String
) : Serializable