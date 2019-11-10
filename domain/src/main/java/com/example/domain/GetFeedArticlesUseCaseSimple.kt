package com.example.domain

import com.example.domain.contracts.repositories.FeedRepositorySimple
import com.example.domain.contracts.usecases.UseCaseSimple
import com.example.domain.entities.Article

class GetFeedArticlesUseCaseSimple //@Inject
    (val feedRepositorySimple: FeedRepositorySimple) :
    UseCaseSimple<Int, List<Article>> {

    override fun execute(feedId: Int, callback: UseCaseSimple.Callback<List<Article>>) {
        try {
            callback.onSuccess(feedRepositorySimple.getFeedArticles(feedId))
        } catch (throwable: Throwable) {
            callback.onError(throwable)
        }

    }
}