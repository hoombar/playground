package com.rdydev.playground

import android.content.Context
import com.rdydev.playground.postdetail.PostDetailActivity
import java.lang.ref.WeakReference

class Navigation(private val context: WeakReference<Context>) {

    fun navigateToPostDetail(postId: Int) {
        context.get()?.run {
            startActivity(PostDetailActivity.getActivityIntent(this, postId))
        }
    }

}

