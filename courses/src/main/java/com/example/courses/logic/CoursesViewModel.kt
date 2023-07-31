package com.example.courses.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.courses.data.CoursesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val coursesRepository: CoursesRepository
): ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _viewState = MutableStateFlow(CoursesViewState())
    val viewState = _viewState.asStateFlow()

    init {
        loadSearchSuggestions()
    }

    val courses: Flow<PagingData<Course>>
        get() = _searchQuery
            .debounce(300)
            .distinctUntilChanged()
            .flatMapLatest {
                coursesRepository.getCourses(it).cachedIn(viewModelScope)
            }

    fun search(query: String) {
        _searchQuery.value = query
    }

    private fun loadSearchSuggestions(){
        viewModelScope.launch {
            searchQuery
                .filter { it.length > 2 }
                .distinctUntilChanged()
                .debounce(300)
                .onEach {
                    _viewState.value = _viewState.value.copy(
                        isSearching = true
                    )
                }
                .map {
                    coursesRepository.getSearchSuggestions(it)
                }
                .collectLatest {
                    _viewState.value = _viewState.value.copy(
                        isSearching = false,
                        searchSuggestions = it
                    )
                }
        }
    }
}