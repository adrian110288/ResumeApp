package com.lesniak.resumeapp.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lesniak.resumeapp.data.ResumeService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun callAdapter(): CallAdapter.Factory =
        CoroutineCallAdapterFactory()

    @Singleton
    @Provides
    fun converterFactory(): Converter.Factory =
        GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create()
        )

    @Singleton
    @Provides
    fun httpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrl(): String =
        "https://gist.githubusercontent.com/adrian110288/"

    @Singleton
    @Provides
    fun retrofit(
        @Named("baseUrl") baseUrl: String,
        callAdapter: CallAdapter.Factory,
        converterFactory: Converter.Factory,
        httpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converterFactory)
            .client(httpClient)
            .build()

    @Singleton
    @Provides
    fun resumeService(retrofit: Retrofit): ResumeService =
        retrofit.create(ResumeService::class.java)
}