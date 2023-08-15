package com.example.coordinator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coordinator.R
import com.example.coordinator.model.Feed

class FeddAdapter(private val feeds:ArrayList<Feed>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var likeClickListener:((Int)->Unit)?=null
    private val IMAGE=0
    private val NO_IMAGE=1


    override fun getItemViewType(position: Int): Int {
        return if(feeds[position].imageUrl==null)  NO_IMAGE else IMAGE

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View
        return when(viewType) {
            NO_IMAGE -> {
                view=LayoutInflater.from(parent.context).inflate(R.layout.iteam_feed,parent,false)
                FeedNoImageViewHolder(view)
            }

            else->{
                view=LayoutInflater.from(parent.context).inflate(R.layout.iteam_feed_image,parent,false)
                FeedImageViewHolder(view)
            }
        }
    }

    override fun getItemCount()=feeds.size



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = feeds[position]
        if (holder is FeedImageViewHolder){
            holder.apply {
                Glide.with(ivUserProfile).load(feed.userImage).into(ivUserProfile)
                Glide.with(ivPost).load(feed.imageUrl).into(ivPost)
                tvUserName.text=feed.username
                tvUserTitle.text=feed.userTitle
                tvPostTime.text=feed.postTime
                if (feed.isFollowed){
                    tvFollow.text="Followed"
                }else{
                    tvFollow.text="+ Follow"
                }
                tvPostShortText.setOnClickListener {

                    tvPostFullText.visibility = View.VISIBLE
                    tvPostShortText.visibility = View.GONE
                }
                    tvPostFullText.setOnClickListener {
                        tvPostFullText.visibility = View.VISIBLE
                        tvPostShortText.visibility = View.GONE
                    }
                    tvPostShortText.text = feed.postText
                    tvPostFullText.text = feed.postText

                if (feed.isLiked){
                    tvLikesCount.text="${feed.likesCount-1}and you"
                    //ivLike.imagetindmode
                }else{
                    tvLikesCount.text="${feed.likesCount}"
                }
                tvCommentCount.text="${feed.commentCount} comments"
                ivLike.setOnClickListener {
                    likeClickListener?.invoke(position)
                }
            }
        }
        if (holder is FeedNoImageViewHolder){
            holder.apply {
                Glide.with(ivUserProfile).load(feed.userImage).into(ivUserProfile)
                tvUserName.text=feed.username
                tvUserTitle.text=feed.userTitle
                tvPostTime.text=feed.postTime
                if (feed.isFollowed){
                    tvFollow.text="Followed"
                }else{
                    tvFollow.text="+ Follow"
                }
                tvPostShortText.text=feed.postText
                tvPostFullText.text=feed.postText
                if (feed.isLiked){
                    tvLikesCount.text="${feed.likesCount-1}and you"
                    //ivLike.imagetindmode
                }else{
                    tvLikesCount.text="${feed.likesCount}"
                }
                tvCommentCount.text="${feed.commentCount} comments"


            }
        }
    }
    class FeedImageViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivUserProfile=view.findViewById<ImageView>(R.id.iv_user)
        val ivPost=view.findViewById<ImageView>(R.id.iv_post)
        val tvUserName=view.findViewById<TextView>(R.id.tv_username)
        val tvUserTitle=view.findViewById<TextView>(R.id.tv_user_title)
        val tvPostTime=view.findViewById<TextView>(R.id.tv_post_time)
        val tvFollow=view.findViewById<TextView>(R.id.tv_follow)
        val tvPostFullText=view.findViewById<TextView>(R.id.tv_post_full_tex)
        val tvPostShortText=view.findViewById<TextView>(R.id.tv_post_short_text)
        val tvLikesCount=view.findViewById<TextView>(R.id.tv_liked_count)
        val tvCommentCount=view.findViewById<TextView>(R.id.tv_comments_count)
        val tvLike=view.findViewById<TextView>(R.id.tv_like)
        val ivLike=view.findViewById<ImageView>(R.id.iv_like)


    }
    class FeedNoImageViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivUserProfile: ImageView =view.findViewById<ImageView>(R.id.iv_profile)
        val tvUserName=view.findViewById<TextView>(R.id.tv_username)
        val tvUserTitle=view.findViewById<TextView>(R.id.tv_user_title)
        val tvPostTime=view.findViewById<TextView>(R.id.tv_post_time)
        val tvFollow=view.findViewById<TextView>(R.id.tv_follow)
        val tvPostFullText=view.findViewById<TextView>(R.id.tv_post_full_tex)
        val tvPostShortText=view.findViewById<TextView>(R.id.tv_post_short_text)
        val tvLikesCount=view.findViewById<TextView>(R.id.tv_liked_count)
        val tvCommentCount=view.findViewById<TextView>(R.id.tv_comments_count)
        val tvLike=view.findViewById<TextView>(R.id.tv_like)
        val ivLike=view.findViewById<TextView>(R.id.iv_like)
    }
}