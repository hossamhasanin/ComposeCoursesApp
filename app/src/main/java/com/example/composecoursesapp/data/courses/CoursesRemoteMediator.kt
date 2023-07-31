package com.example.composecoursesapp.data.courses

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.composecoursesapp.data.local.CoursesAppDB
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CoursesRemoteMediator(
    private val api: CoursesApi,
    private val db: CoursesAppDB
): RemoteMediator<Int, CourseEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CourseEntity>
    ): MediatorResult {
        return try {
            val page = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastPage = state.lastItemOrNull()
                        ?: return MediatorResult.Success(endOfPaginationReached = true)
                    lastPage.id
                }
            }

            val courses = api.getCourses(page)

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.coursesDao.deleteAllCourses()
                }
                db.coursesDao.insertCourses(courses.map { it.toCourseEntity() })
            }

            MediatorResult.Success(endOfPaginationReached = courses.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException){
            MediatorResult.Error(e)
        }
    }
}