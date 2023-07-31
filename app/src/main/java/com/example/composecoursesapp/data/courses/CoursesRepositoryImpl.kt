package com.example.composecoursesapp.data.courses

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.composecoursesapp.data.local.CoursesAppDB
import com.example.courses.data.CoursesRepository
import com.example.courses.logic.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val api: CoursesApi,
    private val db: CoursesAppDB
): CoursesRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getCourses(query: String): Flow<PagingData<Course>> {
        return Pager(
            remoteMediator = CoursesRemoteMediator(api, db),
            pagingSourceFactory = { db.coursesDao.getCourses() },
            config = PagingConfig(
                pageSize = 10
            )
        ).flow.map { courseEntities ->
            courseEntities.map { it.toCourse() }
        }
    }
}