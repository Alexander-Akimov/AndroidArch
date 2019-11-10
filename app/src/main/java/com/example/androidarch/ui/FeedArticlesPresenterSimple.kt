package com.example.androidarch.ui

import com.example.androidarch.mapping.ViewModelMapper
import com.example.domain.contracts.usecases.UseCaseSimple
import com.example.domain.entities.Article
import com.example.domain.GetFeedArticlesUseCaseSimple

class FeedArticlesPresenterSimple//Inject?
    (private val getFeedArticlesUseCase: GetFeedArticlesUseCaseSimple) : UseCaseSimple.Callback<List<Article>> {

    private val viewModelMapper: ViewModelMapper =
        ViewModelMapper()
    private lateinit var view: View

    fun setView(view: View) {
        this.view = view
    }

    fun fetchFeedItems(feedId: Int) {
        getFeedArticlesUseCase.execute(feedId, this)
    }

    override fun onSuccess(articles: List<Article>) {
        view.showArticles(viewModelMapper.mapArticlesToViewModels(articles))
    }

    override fun onError(throwable: Throwable) {
        view.showErrorMessage()
    }
}