package com.rdydev.playground.posts

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class PostsPresenter : KoinComponent {

    private val compositeDisposable = CompositeDisposable()
    private val getPostsUseCase: GetPostsUseCase by inject()

    private lateinit var view: PostsView

    fun bind(view: PostsView) {
        this.view = view
        compositeDisposable.add(loadPosts())
    }

    fun unbind() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    private fun loadPosts() = getPostsUseCase.execute()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { view.render(PostScreenState.LoadingState) }
        .doAfterTerminate { view.render(PostScreenState.FinishState) }
        .subscribe(
            { view.render(PostScreenState.DataState(it)) },
            { view.render(PostScreenState.ErrorState(it)) }
        )
}