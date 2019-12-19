package com.example.androidarch.ui


import com.example.androidarch.mapping.ViewModelMapper
import com.example.domain.GetFeedArticlesUseCase
import com.example.domain.contracts.usecases.UseCase
import com.example.domain.entities.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FeedArticlesPresenter(
    private val getFeedArticlesUseCase: UseCase<Int, List<Article>>
) {

    private val feedViewModelMapper: ViewModelMapper = ViewModelMapper()
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