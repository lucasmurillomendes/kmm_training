package com.lucas.kmmtraining.articles.di

import com.lucas.kmmtraining.articles.data.ArticlesDataSource
import com.lucas.kmmtraining.articles.domain.ArticlesRepository
import com.lucas.kmmtraining.articles.domain.ArticlesService
import com.lucas.kmmtraining.articles.domain.ArticlesUseCase
import com.lucas.kmmtraining.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}