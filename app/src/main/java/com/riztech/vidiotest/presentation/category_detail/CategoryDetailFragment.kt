package com.riztech.vidiotest.presentation.category_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.nioso.core.base.BaseResult
import com.nioso.core.util.*
import com.riztech.vidiotest.R
import com.riztech.vidiotest.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_category_detail.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryDetailFragment : BaseFragment() {
    @Inject
    lateinit var viewModel:CategoryDetailViewModel

    override fun setLayoutId(): Int {
        return R.layout.fragment_category_detail
    }

    override fun daggerInitial() {
        appComponent.getCategoryDetailComponent().inject(this)
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {
        val args: CategoryDetailFragmentArgs by navArgs()

        val category = args.category

        viewModel.getCategoryJoke(category)
    }

    override fun observer() {
        viewModel.responseCategory.observe(viewLifecycleOwner, Observer {
            it.showOnce()?.apply {
                when(this){
                    is BaseResult.Success -> {
                        decrementIdlingResource()
                        placeholder.stopShimmer()
                        placeholder.hide()

                        this.data?.apply {
                                ivIcon.loadImage(
                                    this.icon_url,
                                    getProgressDrawable(requireContext()),
                                    requireContext()
                                )
                                tvJokes.text = this.value
                        }
                    }
                    is BaseResult.Error -> {
                        decrementIdlingResource()
                        placeholder.stopShimmer()
                        placeholder.hide()
                    }
                    is BaseResult.Loading -> {
                        placeholder.startShimmer()
                        placeholder.show()

                    }
                }
            }
        })
    }


}