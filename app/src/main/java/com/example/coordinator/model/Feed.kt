package com.example.coordinator.model

data class Feed(
    val userImage:String,
    val username:String,
    val userTitle:String,
    val postTime:String,
    val postText:String,
    val imageUrl:String?,
    var likesCount:Int,
    var commentCount:Int,
    val isLiked:Boolean=false,
    var isFollowed:Boolean=false,
    var isFull :Boolean=false
)
