package com.example.composecoursesapp.ui.screens.courses

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class Tr: ViewModel() {
    private val _searchField = MutableStateFlow("")

    fun search(query: String) {
        _searchField.value = query
    }

    fun listenToSearch(){
        _searchField
            .debounce(300)
            .filter {
                it.isNotEmpty()
            }
            .onEach {

            }
            .launchIn(viewModelScope)
    }
}