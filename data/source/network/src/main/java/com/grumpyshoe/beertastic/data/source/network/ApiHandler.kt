package com.grumpyshoe.beertastic.data.source.network

import org.json.JSONObject
import retrofit2.Response

inline fun <reified T> handleApi(execute: () -> Response<T>): com.grumpyshoe.beertastic.result.ApiResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful) {
            com.grumpyshoe.beertastic.result.ApiSuccess(body ?: Unit as T)
        } else {
            try {
                val errorBody = response.errorBody()?.string().orEmpty()
                val code = JSONObject(errorBody).getJSONObject("error").getInt("code")
                com.grumpyshoe.beertastic.result.ApiError("ErrorCode = $code")
            } catch (e: Exception) {
                com.grumpyshoe.beertastic.result.ApiError(e.localizedMessage)
            }
        }
    } catch (e: Exception) {
        com.grumpyshoe.beertastic.result.ApiError(e.localizedMessage)
    }
}
