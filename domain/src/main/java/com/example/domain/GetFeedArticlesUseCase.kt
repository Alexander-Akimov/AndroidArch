package com.example.domain

import com.example.domain.contracts.repositories.FeedRepository
import com.example.domain.contracts.usecases.UseCase

import com.example.domain.entities.Article
import io.reactivex.Single

class GetFeedArticlesUseCase //@Inject
    (private val feedRepository: FeedRepository) :
    UseCase<Int, List<Article>> {

    override fun execute(feedId: Int): Single<List<Article>> {
        return feedRepository.getFeedArticles(feedId)
    }
}