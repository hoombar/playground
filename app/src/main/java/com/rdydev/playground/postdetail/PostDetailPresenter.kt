package com.rdydev.playground.postdetail

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class PostDetailPresenter : KoinComponent {

    private val disposable = CompositeDisposable()
    private val getPostUseCase: GetPostUseCase by inject()

    private lateinit var view: PostDetailView

    fun bind(view: PostDetailView, postId: Int) {
        this.view = view
        disposable.add(loadPost(postId))
    }

    fun unbind() {
        if (!disposable.isDisposed) disposable.clear()
    }

    private fun loadPost(postId: Int) = getPostUseCase.execute(postId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { view.render(PostDetailScreenState.LoadingState) }
        .doAfterTerminate { view.render(PostDetailScreenState.FinishState) }
        .doOnError { view.render(PostDetailScreenState.ErrorState(it)) }
        .subscribe({
            view.render(PostDetailScreenState.DataState(it))
        }, {
            view.render(PostDetailScreenState.ErrorState(it))
        })
}
