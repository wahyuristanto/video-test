package com.riztech.vidiotest.domain.usecase

import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(val repository: SearchRepository) {
    suspend fun search(query: String): BaseResult<Response.SearchResult>{
        return repository.search(query)
    }
}