package com.lucas.kmmtraining.android.di

import app.cash.sqldelight.db.SqlDriver
import com.lucas.kmmtraining.db.DatabaseDriverFactory
import com.lucas.kmmtraining.db.KMMTrainingDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<KMMTrainingDatabase> { KMMTrainingDatabase(get()) }
}