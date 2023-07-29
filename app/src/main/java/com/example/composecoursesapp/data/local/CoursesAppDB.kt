package com.example.composecoursesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composecoursesapp.data.courses.CourseEntity
import com.example.composecoursesapp.data.courses.CoursesDao


@Database(entities = [CourseEntity::class], version = 1)
abstract class CoursesAppDB : RoomDatabase() {

    abstract val coursesDao: CoursesDao
}