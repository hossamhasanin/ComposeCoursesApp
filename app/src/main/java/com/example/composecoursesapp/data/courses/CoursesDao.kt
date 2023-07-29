package com.example.composecoursesapp.data.courses

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface CoursesDao {

    @Insert
    suspend fun insertCourses(courses: List<CourseEntity>)

    @Query("SELECT * FROM courses")
    suspend fun getCourses(): PagingSource<Int, CourseEntity>

    @Query("DELETE FROM courses")
    suspend fun deleteAllCourses()

}