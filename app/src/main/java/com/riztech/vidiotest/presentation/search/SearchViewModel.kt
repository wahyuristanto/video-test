package com.riztech.vidiotest.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nioso.core.base.BaseResult
import com.nioso.core.util.LiveOnce
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.usecase.SearchUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val useCase: SearchUseCase): ViewModel() {

    var query = ""
        set(value) {
            field = value
            getSearchByQuery()
        }

    private val _responseCategory = MutableLiveData<LiveOnce<BaseResult<Response.SearchResult>>>()
    val responseCategory: LiveData<LiveOnce<BaseResult<Response.SearchResult>>>
        get() = _responseCategory

    fun getSearchByQuery(){
        viewModelScope.launch {
            _responseCategory.value = LiveOnce(BaseResult.Loading())
            _responseCategory.value = LiveOnce(useCase.search(query))
        }
    }
}