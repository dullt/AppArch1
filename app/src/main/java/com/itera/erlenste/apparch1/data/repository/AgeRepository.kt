package com.itera.erlenste.apparch1.data.repository

import com.itera.erlenste.apparch1.data.datasource.AgeDatasource
import com.itera.erlenste.apparch1.data.model.AgeResponse

class AgeRepository(private val ageDatasource: AgeDatasource) {

    suspend fun getAgeResponse(name: String): AgeResponse {
        return ageDatasource.getAgeResponse(name)
    }
}