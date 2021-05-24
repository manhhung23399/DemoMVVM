package com.example.demomvvm.di

import com.example.demomvvm.data.ApiConfig
import com.example.demomvvm.data.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { initHttpClient() }
    single { initRetrofit(get()) }
    single { createService(get()) }
}

fun initHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    val builder = OkHttpClient.Builder()
    builder.addInterceptor {
        val original = it.request()
        val url = original.url
            .newBuilder()
            .addQueryParameter(ApiConfig.BASE_API_KEY, ApiConfig.BASE_KEY)
            .build()
        val request = original.newBuilder().url(url).build()
        it.proceed(request)
    }
        .addInterceptor(httpLoggingInterceptor)
    return builder.build()
}

fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

fun initRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(ApiConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
