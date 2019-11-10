package com.example.domain.contracts.repositories

import com.example.domain.entities.Article
import com.example.domain.entities.Feed
import io.reactivex.Single

interface FeedRepository {
    fun createNewFeed(feedUrl: String): Single<Int>
    fun getUserFeeds(): Single<List<Feed>>

    fun getFeedArticles(feedId: Int): Single<List<Article>>
    fun deleteFeed(feedId: Int): Single<Boolean>
}