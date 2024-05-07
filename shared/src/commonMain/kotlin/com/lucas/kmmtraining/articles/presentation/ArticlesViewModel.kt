package com.lucas.kmmtraining.articles.presentation

import com.lucas.kmmtraining.BaseViewModel
import com.lucas.kmmtraining.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceRefresh: Boolean = false) {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))

            //to force load
            //delay(1000)

            val fetchedArticles = useCase.getArticles(forceRefresh)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}