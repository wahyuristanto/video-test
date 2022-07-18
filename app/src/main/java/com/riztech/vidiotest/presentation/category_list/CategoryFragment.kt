package com.riztech.vidiotest.presentation.category_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nioso.core.base.BaseResult
import com.nioso.core.util.*
import com.riztech.vidiotest.R
import com.riztech.vidiotest.presentation.adapter.CategoryAdapter
import com.riztech.vidiotest.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_category.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : BaseFragment() {
    @Inject
    lateinit var viewModel: CategoryViewModel

    private val categoryAdapter by lazy {
        CategoryAdapter(requireContext())
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_category
    }

    override fun daggerInitial() {
        appComponent.getCategoryComponent().inject(this)
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {
        rvCategory.init(requireContext())
        categoryAdapter.listen = object : CategoryAdapter.Listener{
            override fun goToDetailCategory(category: String) {
                startFragment(CategoryFragmentDirections.goToDetail(category))
            }
        }

        ivSearch.setOnClickListener {
            startFragment(CategoryFragmentDirections.goToSearch())
        }

        rvCategory.adapter = categoryAdapter
        rvCategory.addItemDecoration(DividerItemDecoration(
            requireContext(),
            RecyclerView.VERTICAL
        ))

        incrementIdlingResource()

    }

    override fun observer() {

        viewModel.responseCategory.observe(viewLifecycleOwner, Observer {
            it.showOnce()?.apply {
                when(this){
                    is BaseResult.Success -> {
                        decrementIdlingResource()
                        placeholder.stopShimmer()
                        placeholder.hide()
                        rvCategory.show()
                        this.data.toMutableList()?.apply {
                            categoryAdapter.addAllItem(this)
                        }
                    }
                    is BaseResult.Error -> {
                        decrementIdlingResource()
                        placeholder.stopShimmer()
                        placeholder.hide()
                        rvCategory.show()
                        Log.d("ERRORVIDIO", this.message?.capitalize() ?: "",)
                    }
                    is BaseResult.Loading -> {
                        placeholder.startShimmer()
                        placeholder.show()
                        rvCategory.hide()
                    }
                }
            }
        })

    }
}