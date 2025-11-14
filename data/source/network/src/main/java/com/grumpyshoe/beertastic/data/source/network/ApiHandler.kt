
package com.grumpyshoe.beertastic.data.source.network

import com.grumpyshoe.beertastic.domain.beer.utils.ApiError
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult
import com.grumpyshoe.beertastic.domain.beer.utils.ApiSuccess
import org.json.JSONObject
import retrofit2.Response

inline fun <reified T> handleApi(execute: () -> Response<T>): ApiResult<T> = try {
    val response = execute()
    val body = response.body()
    if (response.isSuccessful) {
        ApiSuccess(body ?: Unit as T)
    } else {
        try {
            val errorBody = response.errorBody()?.string().orEmpty()
            val code = JSONObject(errorBody).getJSONObject("error").getInt("code")
            ApiError("ErrorCode = $code")
        } catch (e: Exception) {
            ApiError(e.localizedMessage)
        }
    }
} catch (e: Exception) {
    ApiError(e.localizedMessage)
}
