package com.rdydev.playground.posts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rdydev.playground.Navigation
import com.rdydev.playground.R
import com.rdydev.playground.data.model.domain.Post
import kotlinx.android.synthetic.main.activity_posts.*
import java.lang.ref.WeakReference

class PostsActivity : AppCompatActivity(), PostsView {

    private val presenter by lazy {
        PostsPresenter(Navigation(WeakReference(this)))
    }

    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        listOfPosts.layoutManager = LinearLayoutManager(this)
        val separator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        listOfPosts.addItemDecoration(separator)

        presenter.bind(this)
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }

    override fun render(state: PostScreenState) {
        when (state) {
            is PostScreenState.LoadingState -> showLoading()
            is PostScreenState.DataState -> showPosts(state.posts)
            is PostScreenState.ErrorState -> showError(getString(R.string.load_posts_error_message))
            is PostScreenState.FinishState -> hideLoading()
        }
    }

    private fun showLoading() {
        error.visibility = View.GONE
        listOfPosts.visibility = View.GONE
        loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        loading.visibility = View.GONE
    }

    private fun showPosts(posts: List<Post>) {
        // this is a fairly crude implementation, if it was Flowable, it would
        // be better to use DiffUtil and consider notifyRangeChanged, notifyItemInserted, etc
        // to preserve animations on the RecyclerView
        adapter = PostsAdapter(posts, presenter)
        listOfPosts.adapter = adapter
        listOfPosts.visibility = View.VISIBLE
    }

    private fun showError(message: String) {
        error.visibility = View.VISIBLE
        error.setText(message)
    }
}
