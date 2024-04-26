package com.lucas.kmmtraining.articles.di

import com.lucas.kmmtraining.articles.ArticlesService
import com.lucas.kmmtraining.articles.ArticlesUseCase
import com.lucas.kmmtraining.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}