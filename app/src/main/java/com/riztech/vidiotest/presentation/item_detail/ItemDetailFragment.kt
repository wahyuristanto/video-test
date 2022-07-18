package com.riztech.vidiotest.presentation.item_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.nioso.core.util.getProgressDrawable
import com.nioso.core.util.loadImage
import com.riztech.vidiotest.R
import com.riztech.vidiotest.util.BaseFragment
import kotlinx.android.synthetic.main.adapter_list_jokes.ivIcon
import kotlinx.android.synthetic.main.fragment_item_detail.*

// TODO: Rename parameter arguments, choose names that match

/**
 * A simple [Fragment] subclass.
 * Use the [ItemDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemDetailFragment : BaseFragment() {

    override fun setLayoutId(): Int {
        return R.layout.fragment_item_detail
    }

    override fun daggerInitial() {
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {
        val args: ItemDetailFragmentArgs by navArgs()
        val joke = args.joke

        ivIcon.loadImage(joke.icon_url, getProgressDrawable(requireContext()), requireContext())
        tvJokes.text = joke.value
    }

    override fun observer() {
    }
}