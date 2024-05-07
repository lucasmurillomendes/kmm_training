package com.lucas.kmmtraining.articles.domain

import com.lucas.kmmtraining.articles.data.ArticleRaw
import com.lucas.kmmtraining.articles.data.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(
    private val http: HttpClient
) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "784558f8d2dd4c2681112b746ea39b34"

    suspend fun fecthArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = http
            .get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
            .body()

        return response.articles
    }
}