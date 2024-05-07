package com.lucas.kmmtraining.articles.domain

import com.lucas.kmmtraining.articles.data.ArticleRaw
import com.lucas.kmmtraining.articles.data.ArticlesDataSource

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService,
) {
    suspend fun getArticles(forceRefresh: Boolean): List<ArticleRaw> {
        if (forceRefresh) {
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDatabase = dataSource.getAllArticles()
        println("Got ${articlesDatabase.size} lines from database")

        if (articlesDatabase.isEmpty()) {
            return fetchArticles()
        }

        return articlesDatabase
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = articlesService.fecthArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}