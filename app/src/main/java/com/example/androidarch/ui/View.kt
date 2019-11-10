package com.example.androidarch.ui

interface View {
    fun showArticles(feedArticles: List<ArticleViewModel>)
    fun showErrorMessage()
    fun showLoadingIndicator()
}