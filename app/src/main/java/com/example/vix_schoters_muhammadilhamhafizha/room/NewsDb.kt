package com.example.vix_schoters_muhammadilhamhafizha.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import com.example.vix_schoters_muhammadilhamhafizha.util.SourceConverter

@Database(
    entities = [ArticleModel::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(SourceConverter::class)
abstract class NewsDb : RoomDatabase() {
    abstract val newsDao: NewsDao
}