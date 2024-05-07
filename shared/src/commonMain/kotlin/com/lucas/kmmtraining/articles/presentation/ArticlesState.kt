package com.lucas.kmmtraining.articles.presentation

import com.lucas.kmmtraining.articles.domain.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)
