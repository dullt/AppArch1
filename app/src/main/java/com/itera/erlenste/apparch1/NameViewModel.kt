package com.itera.erlenste.apparch1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itera.erlenste.apparch1.data.datasource.AgeDatasource
import com.itera.erlenste.apparch1.data.repository.AgeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NameViewModel() : ViewModel() {

    val ageRepository = AgeRepository(ageDatasource = AgeDatasource())

    private val _names = MutableStateFlow<List<String>>(emptyList())
    val names: StateFlow<List<String>> = _names.asStateFlow()

    fun addName(name: String) {
        viewModelScope.launch {
            Log.i("NameViewModel", "Adding name: $name")
            val response = ageRepository.getAgeResponse(name)
            _names.value += "${response.name} er(${response.age} år gammel"
        }
    }
    // TODO: Implementer ViewModel for å holde styr på tilstand om navn

}