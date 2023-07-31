package com.example.courses.data

import androidx.paging.PagingData
import com.example.courses.logic.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    fun getCourses(query: String): Flow<PagingData<Course>>
    suspend fun getSearchSuggestions(query: String): List<String>
}