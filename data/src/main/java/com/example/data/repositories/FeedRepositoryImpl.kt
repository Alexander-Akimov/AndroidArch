package com.example.data.repositories

import com.example.domain.contracts.repositories.FeedRepository
import com.example.domain.entities.Article
import com.example.domain.entities.Feed
import io.reactivex.Single

class FeedRepositoryImpl : FeedRepository {
    override fun createNewFeed(feedUrl: String): Single<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserFeeds(): Single<List<Feed>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFeedArticles(feedId: Int): Single<List<Article>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFeed(feedId: Int): Single<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}