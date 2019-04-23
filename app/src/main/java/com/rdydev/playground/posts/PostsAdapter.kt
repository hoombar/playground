package com.rdydev.playground.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rdydev.playground.R
import com.rdydev.playground.data.model.domain.Post
import kotlinx.android.synthetic.main.view_post_list_item.view.*

class PostsAdapter(val data: List<Post>) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.view_post_list_item, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(data.get(position))
    }
}

class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Post) {
        view.postTitle.text = item.title
        view.bodyPreview.text = item.body
    }

}