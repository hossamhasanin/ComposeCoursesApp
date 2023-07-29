package com.example.composecoursesapp.data.courses

import androidx.room.Entity

@Entity(tableName = "courses")
data class CourseEntity(
    val id: Int,
    val title: String,
    val teacherName: String,
    val imageUrl: String,
    val price: String,
    val duration: String
)
