package com.example.coingecko.data.di

import com.example.coingecko.data.remote.ApiDetails
import com.example.coingecko.data.remote.ApiRequest
import com.example.coingecko.data.repository.Repository
import com.example.coingecko.data.repository.RepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideGson():Gson{
        return Gson()
    }

    @Provides
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level=HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }

    @Provides
    fun provideRetrofit(
        gson: Gson,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASEURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    fun provideAPI(
        retrofit: Retrofit
    ): ApiRequest {
        return retrofit.create(ApiRequest::class.java)
    }

    @Provides
    fun provideRepository(apiRequest: ApiRequest):Repository{
        return RepositoryImpl(apiRequest)
    }
}