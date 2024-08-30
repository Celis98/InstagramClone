package com.example.instagramclone.ll_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramclone.data.Post
import com.example.instagramclone.R
import com.example.instagramclone.rv_activity.RecyclerViewActivity
import com.example.instagramclone.utils.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var llPosts: LinearLayout
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fillPostList()
        addPostsToLL()
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
             *
             * avoid doing this when inflating any other view
             */
            val postView = layoutInflater.inflate(R.layout.home_post, null)

            val tvUsername: TextView = postView.findViewById(R.id.tvUsername)
            tvUsername.text = post.userName

            /**
             * showToast function can be called from our activity since AppCompactActivity
             * extends from Context
             *
             * kotlin automatically understand the context of every class so it implicitly knows that
             * showToast can be called here, it allows us to omit using this
             */

            val ibLike = postView.findViewById<ImageButton>(R.id.ibLike)
            ibLike.setOnClickListener {
                showToast(
                    text = "ibLike: ${post.userName}"
                )
            }

            /**
             * Kotlin offers different ways to access objects and functions
             */
            postView.findViewById<ImageButton>(R.id.ibComment).setOnClickListener {
                showToast("ibComment ${post.userName}", Toast.LENGTH_LONG)
            }

            llPosts.addView(postView)
        }
    }

    private fun initViews() {
        llPosts = findViewById(R.id.ll_posts)
        findViewById<Button>(R.id.btn_rv).setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}