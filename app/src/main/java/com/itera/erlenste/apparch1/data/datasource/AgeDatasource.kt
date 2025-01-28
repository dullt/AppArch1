package com.itera.erlenste.apparch1.data.datasource

import com.itera.erlenste.apparch1.data.model.AgeResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

class AgeDatasource {
    private val ktorHttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getAgeResponse(name: String): AgeResponse {
        // https://agify.io/documentation
        try {
            return ktorHttpClient.get("https://api.agify.io/?name=$name")
        } catch (e: Exception) {
            return AgeResponse(name = "Her skjedde det noe feil!!!", age = -1, count = -1)
        }
    }
}