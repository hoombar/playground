package com.rdydev.playground

import android.content.Context
import com.rdydev.playground.postdetail.PostDetailActivity

class Navigation(private val context: Context) {

    fun navigateToPostDetail(postId: Int) {
        context.startActivity(PostDetailActivity.getActivityIntent(context, postId))
    }

}

