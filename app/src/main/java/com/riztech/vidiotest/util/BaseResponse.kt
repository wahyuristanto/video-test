package com.nioso.core.base

data class BaseResponse<T>(
    val message: String?,
    var status: String = "",
    var data: T?
) {
    fun isSuccess(): Boolean {
        return status.isNullOrEmpty()
    }
}