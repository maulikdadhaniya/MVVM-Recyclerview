package com.example.testmvvm.retrofit

import retrofit2.Response
import java.io.IOException

abstract class SafeAPIRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {

        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw APIException(
                response.code().toString()
            )
        }
    }

}

class APIException(message: String) : IOException(message)