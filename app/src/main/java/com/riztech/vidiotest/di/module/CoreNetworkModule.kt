package com.riztech.vidiotest.di.module

import android.app.Application
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import com.riztech.vidiotest.BuildConfig
import com.riztech.vidiotest.data.api.JokesApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class CoreNetworkModule() {
    companion object {
        @Singleton
        @Provides
        fun provideOkhttpClient(mainApp: Application): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(ChuckInterceptor(mainApp))
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
        }

        @Singleton
        @Provides
        @Named("tsdb_rest")
        fun provideRestClient(okHttpClient: OkHttpClient): Retrofit {
            val builder = Retrofit.Builder()
            val gson = GsonBuilder()
                .setLenient()
                .create()
            builder.client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
            return builder.build()
        }

        @Singleton
        @Provides
        fun provideAuthService(@Named("tsdb_rest") restAdapter: Retrofit): JokesApiService {
            return restAdapter.create<JokesApiService>(JokesApiService::class.java)
        }
    }
}