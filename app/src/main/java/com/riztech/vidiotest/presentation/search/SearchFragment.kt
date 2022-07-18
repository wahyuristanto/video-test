package com.riztech.vidiotest.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.nioso.core.base.BaseResult
import com.nioso.core.util.*
import com.riztech.vidiotest.R
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.model.Entity
import com.riztech.vidiotest.presentation.adapter.JokesListAdapter
import com.riztech.vidiotest.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : BaseFragment() {
    @Inject
    lateinit var viewModel: SearchViewModel

    private val searchAdapter by lazy {
        JokesListAdapter(requireContext())
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_search
    }

    override fun daggerInitial() {
        appComponent.getSearchComponent().inject(this)
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {

        ivSearch.setOnClickListener {
            etSearch.text?.value?.let {
                viewModel.query = it
            }
        }
        etSearch.doAfterTextChanged {
            it?.value?.let {

            }
        }

        rvSearch.init(requireContext())
        rvSearch.adapter = searchAdapter
        searchAdapter.listen = object: JokesListAdapter.Listener{
            override fun goToDetail(category: Response.Jokes) {
                startFragment(SearchFragmentDirections.goToDetailSearch(category))
            }
        }

        ivBack.setOnClickListener {
            back()
        }
        rvSearch.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                RecyclerView.VERTICAL
            )
        )
    }

    override fun observer() {
        viewModel.responseCategory.observe(viewLifecycleOwner, Observer {
            it.showOnce()?.apply {
                when(this){
                    is BaseResult.Success -> {
                        decrementIdlingResource()
                        placeholder.stopShimmer()
                        placeholder.hide()
                        rvSearch.show()
                        this.data.result?.toMutableList()?.apply {
                            searchAdapter.setItem(this)
                        }
                    }
                    is BaseResult.Error -> {
                        decrementIdlingResource()
                        placeholder.stopShimmer()
                        placeholder.hide()
                        rvSearch.show()
                        Log.d("ERRORVIDIO", this.message?.capitalize() ?: "",)
                    }
                    is BaseResult.Loading -> {
                        placeholder.startShimmer()
                        placeholder.show()
                        rvSearch.hide()
                    }
                }
            }
        })
    }


}