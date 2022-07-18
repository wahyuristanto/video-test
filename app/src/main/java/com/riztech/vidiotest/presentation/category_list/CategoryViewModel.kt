package com.riztech.vidiotest.presentation.category_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nioso.core.base.BaseResponse
import com.nioso.core.base.BaseResult
import com.nioso.core.util.LiveOnce
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.usecase.CategoryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(val useCase: CategoryUseCase): ViewModel() {

    private val _responseCategory = MutableLiveData<LiveOnce<BaseResult<List<String>>>>()
    val responseCategory: LiveData<LiveOnce<BaseResult<List<String>>>>
        get() = _responseCategory

    init {
        getCategory()
    }

    fun getCategory(){
        viewModelScope.launch {
            _responseCategory.value = LiveOnce(BaseResult.Loading())
            val rst = useCase.getCategory()
            _responseCategory.value = LiveOnce(rst)
        }
    }
}