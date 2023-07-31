package com.example.composecoursesapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composecoursesapp.data.courses.CoursesApi
import com.example.composecoursesapp.data.local.CoursesAppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.codinginflow.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoursesApi(retrofit: Retrofit): CoursesApi {
        return retrofit.create(CoursesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoursesAppDB(
        @ApplicationContext context: Context
    ): CoursesAppDB {
        return Room.databaseBuilder(
            context,
            CoursesAppDB::class.java,
            "courses.db"
        ).build()
    }
}