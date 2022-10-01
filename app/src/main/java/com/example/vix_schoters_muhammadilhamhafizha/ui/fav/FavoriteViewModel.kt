package com.example.vix_schoters_muhammadilhamhafizha.ui.fav

import androidx.lifecycle.ViewModel
import com.example.vix_schoters_muhammadilhamhafizha.network.NewsRepository
import org.koin.dsl.module

val favoriteViewModel = module {
    factory { FavoriteViewModel(get()) }
}

class FavoriteViewModel(repository: NewsRepository) : ViewModel() {
    val title = "Favorite"
    val articles = repository.db.findAll()
}