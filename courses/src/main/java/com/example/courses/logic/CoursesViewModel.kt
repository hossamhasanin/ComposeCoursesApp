package com.example.courses.logic

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val coursesFlow: Flow<PagingData<Course>>
): ViewModel() {
    fun getCourses(): Flow<PagingData<Course>> {
        return coursesFlow
    }
}