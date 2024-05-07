package com.lucas.kmmtraining.articles.data

import com.lucas.kmmtraining.db.KMMTrainingDatabase

class ArticlesDataSource(
    private val database: KMMTrainingDatabase
) {
    fun getAllArticles(): List<ArticleRaw> =
        database.kMMTrainingDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.kMMTrainingDatabaseQueries.transaction {
            articles.forEach {
                insertArticle(it)
            }
        }
    }

    fun clearArticles() =
        database.kMMTrainingDatabaseQueries.removeAllArticles()

    private fun insertArticle(article: ArticleRaw) {
        database.kMMTrainingDatabaseQueries.insertArticle(
            article.title,
            article.description,
            article.date,
            article.imageUrl,
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw {
        return ArticleRaw(title, desc, date, url)
    }

}