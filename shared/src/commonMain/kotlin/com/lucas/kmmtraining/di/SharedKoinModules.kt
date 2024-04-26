package com.lucas.kmmtraining.di

import com.lucas.kmmtraining.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)