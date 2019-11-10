package com.example.domain.contracts.repositories

import com.example.domain.entities.Article
import com.example.domain.entities.Feed

interface FeedRepositorySimple {
    fun createNewFeed(feedUrl: String): Int
    fun getUserFeeds(): List<Feed>

    fun getFeedArticles(feedId: Int): List<Article>
    fun deleteFeed(feedId: Int): Boolean
}