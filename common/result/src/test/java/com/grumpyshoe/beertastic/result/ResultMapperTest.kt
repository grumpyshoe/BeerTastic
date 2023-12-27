package com.grumpyshoe.beertastic.result

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ResultMapperTest {

    @Test
    fun `ApiSuccess data - transformed correctly`() {

        // trigger action
        val actual = runBlocking {
            ApiSuccess("5").mapResult {
                it.toInt()
            }
        }

        // check assertions
        assertTrue(actual is ApiSuccess<Int>)
        assertEquals(5, (actual as ApiSuccess).data)
    }

    @Test
    fun `ApiError data - transformed correctly`() {

        // trigger action
        val actual = runBlocking {
            ApiError<String>("dummyError").mapResult {}
        }

        // check assertions
        assertTrue(actual is ApiError)
        assertEquals("dummyError", (actual as ApiError).msg)
    }

    @Test
    fun `ApiError data - on exception - transformed correctly`() {

        // trigger action
        val actual = runBlocking {
            ApiSuccess("test").mapResult {
                it.toInt()
            }
        }

        // check assertions
        assertTrue(actual is ApiError)
    }
}
