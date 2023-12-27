package com.grumpyshoe.beertastic.result

sealed interface ApiResult<out T>
data class ApiSuccess<out T>(val data: T) : ApiResult<T>
data class ApiError<out T>(val msg: String?) : ApiResult<T>

inline fun <T> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
    if (this is ApiSuccess) {
        action(this.data)
        return this
    }
    return this
}

inline fun <T> ApiResult<T>.onError(action: (String?) -> Unit): ApiResult<T> {
    if (this is ApiError) {
        action(this.msg)
        return this
    }
    return this
}
