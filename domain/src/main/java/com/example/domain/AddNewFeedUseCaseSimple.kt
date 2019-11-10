package com.example.domain

import com.example.domain.contracts.repositories.FeedRepositorySimple
import com.example.domain.contracts.usecases.CompletableUseCaseSimple
import com.example.domain.contracts.validators.FeedValidator

class AddNewFeedUseCaseSimple //@Inject
    (private val feedValidator: FeedValidator,
     private val feedRepositorySimple: FeedRepositorySimple) :
    CompletableUseCaseSimple<String> {


    override fun execute(feedUrl: String, callback: CompletableUseCaseSimple.Callback) {
        if (feedValidator.isValid(feedUrl)) {
            onValidFeedUrl(feedUrl, callback)
        } else {
            callback.onError(InvalidFeedUrlException())
        }
    }

    private fun onValidFeedUrl(feedUrl: String, callback: CompletableUseCaseSimple.Callback) {
        try {
            feedRepositorySimple.createNewFeed(feedUrl)
            callback.onSuccess()
        } catch (throwable: Throwable) {
            callback.onError(throwable)
        }

    }
}