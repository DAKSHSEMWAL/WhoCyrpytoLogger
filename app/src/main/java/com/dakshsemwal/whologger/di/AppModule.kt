package com.dakshsemwal.whologger.di

import com.dakshsemwal.whologger.common.Constants.BASE_URL
import com.dakshsemwal.whologger.data.remote.CoinPaprikaApi
import com.dakshsemwal.whologger.data.repository.CoinRepositoryImpl
import com.dakshsemwal.whologger.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api = api)

    /**
     * Provides Api By Using Retrofit Dependency
     */
    @Provides
    @Singleton
    fun providePaprikaApi(retrofit: Retrofit): CoinPaprikaApi =
        retrofit.create(CoinPaprikaApi::class.java)

    /**
     * Provides OKHttp client to be used across the app
     */
    @Singleton
    @Provides
    fun provideOKHttp(
        httpLogger: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(1, TimeUnit.MINUTES)
            writeTimeout(1, TimeUnit.MINUTES)
            readTimeout(1, TimeUnit.MINUTES)
            addInterceptor(httpLogger)
        }.build()
    }

    /**
     * Provides HTTP request logger to be used across the app
     */
    @Singleton
    @Provides
    fun provideOKHttpLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(BASE_URL)
        }.build()
    }

}