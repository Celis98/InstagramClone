package com.example.instagramclone.rv_activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.data.Post
import com.example.instagramclone.rv_activity.adapters.RVAdapterPosts
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvPosts: RecyclerView
    private lateinit var btnObtainPosts: Button
    private lateinit var btnRemovePost: Button
    private lateinit var btnModifyPost: Button
    private lateinit var rvAdapterPost: RVAdapterPosts
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initViews()
    }

    private fun initViews() {
        // btnObtainPosts
        btnObtainPosts = findViewById(R.id.btnFillPostList)
        btnObtainPosts.setOnClickListener {
            fillPostList()
            rvAdapterPost.notifyDataSetChanged()
        }

        // btnRemovePost
        btnRemovePost = findViewById(R.id.btnRemovePost)
        btnRemovePost.setOnClickListener {
            // Obtain index to be removed
            val postToRemoveIndex = Random.nextInt(from = 0, until = postList.size)
            // Remove post by index
            postList.removeAt(postToRemoveIndex)
            // Notify adapter using index that item was removed
            rvAdapterPost.notifyItemRemoved(postToRemoveIndex)
        }

        // btnModifyPost
        btnModifyPost = findViewById(R.id.btnModifyPost)
        btnModifyPost.setOnClickListener {
            // Obtain random index to be modified
            val postToUpdateIndex = Random.nextInt(from = 0, until = postList.size)
            // Create modified post
            val post =
                // Access post using index
                postList[postToUpdateIndex]
                    // Using copy, we access and modify the existing post (accessed by index)
                    .copy(
                        userName = "Username #$postToUpdateIndex modificado"
                    )
            // Replace the old post with the new one using index
            postList[postToUpdateIndex] = post
            // Notify adapter using index that item was modified
            rvAdapterPost.notifyItemChanged(postToUpdateIndex)
        }

        // rvPost
        rvPosts = findViewById(R.id.rv_posts)
        initRV()
    }

    private fun initRV() {
        // Adapter initialization, passing postList as parameter
        rvAdapterPost = RVAdapterPosts(posts = postList)
        rvPosts.apply {
            // Set layoutManager for recyclerview
            layoutManager =
                LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            // Set adapter to recyclerview
            adapter = rvAdapterPost
        }
    }

    private fun fillPostList() {
        for (i in 0 until 4) {
            postList.add(Post("Username #$i"))
        }
    }
}