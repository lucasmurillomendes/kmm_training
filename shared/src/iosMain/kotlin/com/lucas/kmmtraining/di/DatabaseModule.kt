package com.lucas.kmmtraining.di

import app.cash.sqldelight.db.SqlDriver
import com.lucas.kmmtraining.db.DatabaseDriverFactory
import com.lucas.kmmtraining.db.KMMTrainingDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<KMMTrainingDatabase> { KMMTrainingDatabase(get()) }
}