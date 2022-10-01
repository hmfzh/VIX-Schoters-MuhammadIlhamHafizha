package com.example.vix_schoters_muhammadilhamhafizha.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vix_schoters_muhammadilhamhafizha.model.NewsModel
import com.example.vix_schoters_muhammadilhamhafizha.network.NewsRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module
import kotlin.math.ceil

val homeNewsViewModel = module {
    factory { HomeNewsViewModel(get()) }
}

class HomeNewsViewModel (
    private val repository: NewsRepository
) : ViewModel() {


    val news by lazy{ MutableLiveData<NewsModel>() }
    val message by lazy{ MutableLiveData<String>() }
    val loading by lazy{ MutableLiveData<Boolean>() }
    val loadMore by lazy { MutableLiveData<Boolean>() }

    init {
        fetch()
        message.value = null
    }

    var query = " "
    var page = 1
    var total = 1
    val title = "Berita"

    fun fetch(){
        if (page > 1) loadMore.value = true else loading.value = true
        viewModelScope.launch{
            try {
                val response = repository.fetch( query, page)
                news.value = response
                val totalResults: Double = response.totalResults / 20.0
                total = ceil(totalResults).toInt()
                page ++
                loading.value = false
                loadMore.value = false
            }catch (e:Exception){
                message.value = "Terjadi Kesalahan"
            }
        }
    }


}