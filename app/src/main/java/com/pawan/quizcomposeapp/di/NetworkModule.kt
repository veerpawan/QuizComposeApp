package com.pawan.quizcomposeapp.di

import com.pawan.quizcomposeapp.api.QuizApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://quizapi.io")
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    @Singleton
    @Provides
    fun providesQuizApi(retrofit: Retrofit): QuizApi{
       return retrofit.create(QuizApi::class.java)
    }
}