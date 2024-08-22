package com.example.instagramclone

import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ibLike: ImageButton
    private lateinit var ibComment: ImageButton
    private lateinit var ibShare: ImageButton
    private lateinit var ibSave: ImageButton
    private lateinit var llPosts: LinearLayout
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
        fillPostList()
        addPostsToLL()
    }

    private fun initListeners() {
        /**
         * showToast function can be called from our activity since AppCompactActivity
         * extends from Context
         *
         * kotlin automatically understand the context of every class so it implicitly knows that
         * showToast can be called here, it allows us to omit using this
         */
        ibLike.setOnClickListener {
            showToast("ibLike")
        }
        ibComment.setOnClickListener {
            this.showToast("ibComment")
        }
        ibShare.setOnClickListener {
            showToast("ibShare")
        }
        ibSave.setOnClickListener {
            showToast("ibSave")
        }
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("Username $i"))
        }
    }

    private fun addPostsToLL() {
        postList.forEach { post ->
            /**
             * When using LinearLayout, the inflated view needs a null root
             * avoid doing this when inflating any other view
             */
            val postView = layoutInflater.inflate(R.layout.home_post, null)
            val tvUsername: TextView = postView.findViewById(R.id.tvUsername)
            tvUsername.text = post.userName
            llPosts.addView(postView)
        }
    }

    private fun initViews() {
        ibLike = findViewById(R.id.ibLike)
        ibComment = findViewById(R.id.ibComment)
        ibShare = findViewById(R.id.ibShare)
        ibSave = findViewById(R.id.ibSave)
        llPosts = findViewById(R.id.ll_posts)
    }
}