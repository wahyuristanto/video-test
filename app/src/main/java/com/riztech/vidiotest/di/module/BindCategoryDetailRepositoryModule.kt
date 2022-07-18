package com.riztech.vidiotest.di.module

import com.riztech.vidiotest.data.repository.CategoryDetailRepositoryImpl
import com.riztech.vidiotest.domain.repository.CategoryDetailRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindCategoryDetailRepositoryModule {
    @Binds
    abstract fun provideCategoryDetailRepository(categoryDetailRepositoryImpl: CategoryDetailRepositoryImpl): CategoryDetailRepository
}