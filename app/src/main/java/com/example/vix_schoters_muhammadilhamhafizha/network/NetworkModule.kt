package com.example.vix_schoters_muhammadilhamhafizha.network

import com.example.vix_schoters_muhammadilhamhafizha.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit( get() ) }
    single { provideNewsApi(get()) }
}

fun provideOkHttpClient() : OkHttpClient {
    return  OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client( okHttpClient )
        .addConverterFactory (
            GsonConverterFactory.create(
                GsonBuilder().serializeNulls().create()
            )
        )
        .build()
}

fun provideNewsApi(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)
