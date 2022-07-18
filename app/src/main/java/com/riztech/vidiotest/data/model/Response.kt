package com.riztech.vidiotest.data.model

import java.io.Serializable

sealed class Response {
    data class SearchResult(
        val total: Int,
        val result: List<Jokes>
    )
    
    data class Jokes(
        val categories: List<String>,
        val created_at: String,
        val icon_url: String,
        val id: String,
        val updated_at: String,
        val url: String,
        val value: String
    ): Response(), Serializable
}