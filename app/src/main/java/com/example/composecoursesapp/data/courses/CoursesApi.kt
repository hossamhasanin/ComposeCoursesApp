package com.example.composecoursesapp.data.courses

import com.example.base.data.courses.CourseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApi {

    @GET("courses")
    suspend fun getCourses(
        @Query("page") page: Int,
        @Query("pageSize") limit: Int = 10
    ): List<CourseDto>
}