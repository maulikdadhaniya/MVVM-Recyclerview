package com.example.testmvvm.response

data class MovieResponse(
    val o_data: List<OData>,
    val o_message: String,
    val o_returnCode: Boolean
)