package com.example.vix_schoters_muhammadilhamhafizha.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class NewsModel (
    val status : String,
    val totalResults: Int,
    val articles: List<ArticleModel>
)

@Entity(tableName = "tableBerita")
data class ArticleModel (
    val source: SourceModel?,
    val author: String?,
    val title: String? ,
    val description: String? ,
    val url: String?,
    val urlToImage: String?,
    @PrimaryKey(autoGenerate = false)
    val publishedAt: String,
    val content: String?,
): Serializable

data class SourceModel (
    val id: String? ,
    val name: String?
): Serializable