package com.parkwhere.project.domain.result

import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.io.IOException

sealed interface DataError: Error {
    enum class Remote: DataError {
        REQUEST_TIMEOUT,
        NO_INTERNET,
        UNABLE_TO_REACH_SERVER,
        SSL_ERROR,
        BAD_REQUEST,
        UNAUTHORIZED,
        ACCESS_DENIED,
        NOT_FOUND,
        SERVER_ERROR,
        UNKNOWN
    }

    enum class Local: DataError {
        FILE_NOT_FOUND,
        UNKNOWN
    }
}

fun Throwable.toDataError(): DataError {
    return when (this) {

        is ClientRequestException -> when (response.status.value) {
            400 -> DataError.Remote.BAD_REQUEST
            401 -> DataError.Remote.UNAUTHORIZED
            403 -> DataError.Remote.ACCESS_DENIED
            404 -> DataError.Remote.NOT_FOUND
            in 500..599 -> DataError.Remote.SERVER_ERROR
            else -> DataError.Remote.UNKNOWN
        }

        is UnresolvedAddressException -> DataError.Remote.NO_INTERNET

        is SocketTimeoutException -> DataError.Remote.REQUEST_TIMEOUT

        is IOException -> {
            if (message?.contains("SSL", ignoreCase = true) == true) {
                DataError.Remote.SSL_ERROR
            } else {
                DataError.Remote.UNABLE_TO_REACH_SERVER
            }
        }

        is IllegalArgumentException  -> {
            if (this.message?.contains("file", ignoreCase = true) == true) {
                DataError.Local.FILE_NOT_FOUND
            } else {
                throw this
            }
        }

        else -> throw this
    }
}