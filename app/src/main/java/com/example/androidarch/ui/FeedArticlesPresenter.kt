package com.example.androidarch.ui


import com.example.androidarch.mapping.ViewModelMapper
import com.example.domain.GetFeedArticlesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FeedArticlesPresenter(
    private val getFeedArticlesUseCase: GetFeedArticlesUseCase
) {

    private val feedViewModelMapper: ViewModelMapper =
        ViewModelMapper()
    private lateinit var view: View

    fun setView(view: View) {
        this.view = view
    }

    fun fetchFeedItems(feedId: Int) {
        var disposable = getFeedArticlesUseCase.execute(feedId)
            .map(feedViewModelMapper::mapFeedItemsToViewModels)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(articlesViewModels: List<ArticleViewModel>) {
        view.showArticles(articlesViewModels)
    }

    private fun onError(throwable: Throwable) {
        view.showErrorMessage()
    }

}