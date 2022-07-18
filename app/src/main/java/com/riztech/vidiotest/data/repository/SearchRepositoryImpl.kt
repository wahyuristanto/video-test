package com.riztech.vidiotest.data.repository

import com.nioso.core.base.BaseResult
import com.nioso.core.util.safeApiCall
import com.riztech.vidiotest.data.api.JokesApiService
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(val api: JokesApiService) : SearchRepository {
    override suspend fun search(query: String): BaseResult<Response.SearchResult> {
        return safeApiCall(Dispatchers.IO){
            api.search(query)
        }
    }
}