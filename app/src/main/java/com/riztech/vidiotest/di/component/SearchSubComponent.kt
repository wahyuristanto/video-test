package com.riztech.vidiotest.di.component

import com.riztech.vidiotest.di.module.BindSearchRepositoryModule
import com.riztech.vidiotest.presentation.search.SearchFragment
import com.riztech.vidiotest.presentation.search.SearchViewModel
import dagger.Subcomponent

@Subcomponent(modules = [BindSearchRepositoryModule::class])
interface SearchSubComponent {
    val viewModel: SearchViewModel
    fun inject(searchFragment: SearchFragment)
}