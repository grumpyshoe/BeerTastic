
package com.grumpyshoe.beertastic.domain.beer.utils

suspend fun <T, C> ApiResult<T>.mapResult(mapper: suspend (T) -> C?): ApiResult<C> = when (this) {
    is ApiError -> ApiError(msg)
    is ApiSuccess -> {
        try {
            val mappingResult = mapper(data)
            if (mappingResult == null) ApiError(null) else ApiSuccess(mappingResult)
        } catch (e: Exception) {
            ApiError(msg = e.localizedMessage)
        }
    }
}
