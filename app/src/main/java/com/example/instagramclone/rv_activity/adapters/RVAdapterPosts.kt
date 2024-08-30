package com.example.instagramclone.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.data.Post

class RVAdapterPosts(private val posts: List<Post>) :
    RecyclerView.Adapter<RVAdapterPosts.PostViewHolder>() {

    /**
     * PostViewHolder receives a view that is used to inflate the views inside the selected layout
     * in this case, [R.layout.home_post] is the received layout
     */
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Inflate tvUserName using the received view
        val tvUserName: TextView = view.findViewById(R.id.tvUsername)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        // Inflate layout to be used in the recyclerview
        val postView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_post, parent, false)
        return PostViewHolder(postView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        // Accessing tvUserName though holder (which is a PostViewHolder) we can
        // set a text to the tvUserName
        // The received position is used to access the current post in the post list
        holder.tvUserName.text = posts[position].userName
    }

    override fun getItemCount(): Int = posts.size

}