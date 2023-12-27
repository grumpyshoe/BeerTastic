package com.grumpyshoe.beertastic.result

suspend fun <T, C> ApiResult<T>.mapResult(mapper: suspend (T) -> C?): ApiResult<C> {
    return when (this) {
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
}
