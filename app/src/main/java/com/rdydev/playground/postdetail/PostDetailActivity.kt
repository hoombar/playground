package com.rdydev.playground.postdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class PostDetailActivity : AppCompatActivity(), PostDetailView {

    private val presenter = PostDetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        presenter.bind(this)
    }

    companion object {

        const val ARG_POST_ID = "POST_ID"

        fun getActivityIntent(context: Context, postId: Int): Intent {
            return Intent(context, PostDetailActivity::class.java).apply {
                putExtra(ARG_POST_ID, postId)
            }
        }
    }
}