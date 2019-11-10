package com.example.domain.contracts.validators

interface FeedValidator {
    fun isValid(feedUrl: String): Boolean
}