package com.riztech.vidiotest.data.repository

import com.nioso.core.base.BaseResponse
import com.nioso.core.base.BaseResult
import com.nioso.core.util.safeApiCall
import com.riztech.vidiotest.data.api.JokesApiService
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(val api: JokesApiService): CategoryRepository {
    override suspend fun getCategory(): BaseResult<List<String>> {
        return safeApiCall(Dispatchers.IO){
            api.getCategories()
        }
    }
}