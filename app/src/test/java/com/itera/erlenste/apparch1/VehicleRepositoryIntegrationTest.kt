package com.itera.erlenste.apparch1

import com.itera.erlenste.apparch1.data.datasource.AgeDatasource
import com.itera.erlenste.apparch1.data.repository.AgeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test


class VehicleRepositoryIntegrationTest {
    @Test
    fun testGetAge_success() {
        val repository = AgeRepository(AgeDatasource())
        val name = "Anja"

        runBlocking {
            val result = repository.getAgeResponse(name)
            Assert.assertNotNull(result)
            Assert.assertEquals(name, result.name)
        }
    }

}