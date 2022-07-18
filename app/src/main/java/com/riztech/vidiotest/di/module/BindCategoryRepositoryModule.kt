package com.riztech.vidiotest.di.module

import com.riztech.vidiotest.data.repository.CategoryRepositoryImpl
import com.riztech.vidiotest.domain.repository.CategoryRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindCategoryRepositoryModule {
    @Binds
    abstract fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository
}