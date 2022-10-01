package com.example.vix_schoters_muhammadilhamhafizha.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel

@Dao
interface NewsDao {

    @Query("SELECT * FROM tableBerita")
    fun findAll(): LiveData<List<ArticleModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun save(articleModel: ArticleModel)

    @Query("SELECT COUNT(*) FROM tableBerita WHERE publishedAt=:publish")
    suspend fun find(publish: String): Int

    @Delete
    suspend fun remove(articleModel: ArticleModel)
}