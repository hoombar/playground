package com.rdydev.playground.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rdydev.playground.R
import kotlinx.android.synthetic.main.activity_main.*

class PostsActivity : AppCompatActivity() {

    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PostsAdapter()
        listOfPosts.adapter = adapter
        listOfPosts.layoutManager = LinearLayoutManager(this)
    }
}
