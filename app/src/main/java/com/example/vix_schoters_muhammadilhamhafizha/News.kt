package com.example.vix_schoters_muhammadilhamhafizha
import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.vix_schoters_muhammadilhamhafizha.network.networkModule
import com.example.vix_schoters_muhammadilhamhafizha.network.repositoryModul
import com.example.vix_schoters_muhammadilhamhafizha.room.databaseModule
import com.example.vix_schoters_muhammadilhamhafizha.ui.detail.detailModule
import com.example.vix_schoters_muhammadilhamhafizha.ui.detail.detailViewModel
import com.example.vix_schoters_muhammadilhamhafizha.ui.fav.favoriteModule
import com.example.vix_schoters_muhammadilhamhafizha.ui.fav.favoriteViewModel
import com.example.vix_schoters_muhammadilhamhafizha.ui.home.homeNewsModule
import com.example.vix_schoters_muhammadilhamhafizha.ui.home.homeNewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class News : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            androidContext(this@News)
            modules(
                networkModule,
                repositoryModul,
                homeNewsViewModel,
                homeNewsModule,
                databaseModule,
                detailModule,
                detailViewModel,
                favoriteModule,
                favoriteViewModel,
            )
        }
    }
}