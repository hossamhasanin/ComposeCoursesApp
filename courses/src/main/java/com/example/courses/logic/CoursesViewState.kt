package com.example.courses.logic

data class CoursesViewState(
    val isSearching: Boolean = false,
    val searchSuggestions: List<String> = emptyList(),
)
