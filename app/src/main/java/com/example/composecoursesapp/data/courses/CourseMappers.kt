package com.example.composecoursesapp.data.courses

import com.example.base.data.courses.CourseDto
import com.example.courses.logic.Course

fun CourseDto.toCourseEntity(): CourseEntity {
    return CourseEntity(
        id = id,
        title = title,
        teacherName = teacherName,
        imageUrl = imageUrl,
        price = price,
        duration = duration
    )
}

fun CourseEntity.toCourse(): Course {
    return Course(
        id = id,
        title = title,
        teacherName = teacherName,
        imageUrl = imageUrl,
        price = price,
        duration = duration
    )
}