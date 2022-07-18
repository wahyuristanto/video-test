package com.riztech.vidiotest.domain.repository

import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response


interface SearchRepository {
    suspend fun search(query: String): BaseResult<Response.SearchResult>
}