package com.riztech.vidiotest.presentation.category_list

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.nioso.core.util.EspressoIdlingResource
import com.riztech.vidiotest.R
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@LargeTest
@RunWith(AndroidJUnit4::class)
class CategoryFragmentTest {
    val mockNavController = Mockito.mock(NavController::class.java)

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingresource)
        launchFragmentInContainer<CategoryFragment>(themeResId = R.style.AppTheme)
    }

    @After
    fun teardown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingresource)
    }

    @Test
    fun getCategory(){
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))

        onView(withId(R.id.placeholder)).check(matches(not(isDisplayed())))
        onView(withId(R.id.rvCategory)).check(matches(isDisplayed()))

    }
}