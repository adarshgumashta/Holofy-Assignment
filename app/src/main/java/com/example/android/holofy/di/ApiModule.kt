package com.example.android.holofy.di

import com.example.android.holofy.network.ApiClient
import com.example.android.holofy.network.ApiService
import com.example.android.holofy.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    public fun getApiService(): ApiService {
        val retrofit =
            Retrofit.Builder().baseUrl().addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(ApiService::class.java)
        return retrofit
    }

    @Provides
    @Singleton
    public fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        okHttpClient.addInterceptor(loggingInterceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    public fun getApiClient(apiService: ApiService): ApiClient {
        return ApiClient(apiService)
    }

    @Provides
    @Singleton
    public fun getRepository(apiClient: ApiClient): Repository {
        return Repository(apiClient)
    }
}