package com.example.composecoursesapp.di.courses

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.composecoursesapp.data.courses.CourseEntity
import com.example.composecoursesapp.data.courses.CoursesApi
import com.example.composecoursesapp.data.courses.CoursesRemoteMediator
import com.example.composecoursesapp.data.courses.CoursesRepositoryImpl
import com.example.composecoursesapp.data.courses.toCourse
import com.example.composecoursesapp.data.local.CoursesAppDB
import com.example.courses.data.CoursesRepository
import com.example.courses.logic.Course
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Module
@InstallIn(ViewModelComponent::class)
abstract class CoursesModule {

    @Binds
    abstract fun bindCoursesRepository(
        coursesRepositoryImpl: CoursesRepositoryImpl
    ): CoursesRepository

}