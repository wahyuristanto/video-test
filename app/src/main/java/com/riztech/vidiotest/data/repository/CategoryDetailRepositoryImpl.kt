package com.riztech.vidiotest.data.repository

import com.nioso.core.base.BaseResult
import com.nioso.core.util.safeApiCall
import com.riztech.vidiotest.data.api.JokesApiService
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.CategoryDetailRepository
import com.riztech.vidiotest.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CategoryDetailRepositoryImpl @Inject constructor(val api: JokesApiService): CategoryDetailRepository {
    override suspend fun getCategoryJoke(category: String): BaseResult<Response.Jokes> {
        return safeApiCall(Dispatchers.IO){
            api.getDetailCategory(category)
        }
    }
}