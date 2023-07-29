package com.example.composecoursesapp.data.courses

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.composecoursesapp.data.local.CoursesAppDB
import com.example.courses.data.CoursesApi

@OptIn(ExperimentalPagingApi::class)
class CoursesRemoteMediator(
    private val api: CoursesApi,
    private val db: CoursesAppDB
): RemoteMediator<Int, CourseEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CourseEntity>
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}