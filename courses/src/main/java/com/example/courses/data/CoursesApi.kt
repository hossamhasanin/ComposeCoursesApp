package com.example.courses.data

import com.example.base.data.courses.CourseDto
import retrofit2.http.GET

interface CoursesApi {

    @GET("courses")
    suspend fun getCourses(): List<CourseDto>
}