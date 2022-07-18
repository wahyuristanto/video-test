package com.riztech.vidiotest.presentation.category_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nioso.core.base.BaseResult
import com.nioso.core.util.LiveOnce
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.usecase.CategoryDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryDetailViewModel @Inject constructor(val useCase: CategoryDetailUseCase): ViewModel() {
    private val _responseCategory = MutableLiveData<LiveOnce<BaseResult<Response.Jokes>>>()
    val responseCategory: LiveData<LiveOnce<BaseResult<Response.Jokes>>>
        get() = _responseCategory

    fun getCategoryJoke(category: String){
        viewModelScope.launch {
            _responseCategory.value = LiveOnce(BaseResult.Loading())
            val rst = useCase.getDetailCategory(category)
            _responseCategory.value = LiveOnce(rst)
        }
    }
}