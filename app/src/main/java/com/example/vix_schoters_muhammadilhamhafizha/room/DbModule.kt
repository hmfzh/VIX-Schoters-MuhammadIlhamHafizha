package com.example.vix_schoters_muhammadilhamhafizha.room

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(androidApplication()) }
    single { provideArticle(get()) }
}

fun provideDatabase(application: Application): NewsDb {
    return Room.databaseBuilder(application, NewsDb::class.java, "d3ifBerita.db")
        .fallbackToDestructiveMigration()
        .build()
}

fun provideArticle(database: NewsDb): NewsDao {
    return  database.newsDao
}