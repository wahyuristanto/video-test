package com.riztech.vidiotest.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.riztech.vidiotest.R
import com.riztech.vidiotest.util.BaseRecylerAdapter
import com.riztech.vidiotest.util.BaseViewHolder
import kotlinx.android.synthetic.main.adapter_category.view.*

class CategoryAdapter(private val ctx: Context): BaseRecylerAdapter<String, CategoryAdapter.ViewHolder>(ctx) {

    lateinit var listen: Listener

    public interface Listener{
        fun goToDetailCategory(category: String)
    }

    class ViewHolder(
        itemView: View,
        val listener: Listener,
        val ctx: Context
    ) :
        BaseViewHolder<String>(itemView) {

        override fun onBind(item: String) {
            itemView.tvCategory.text = item

            itemView.setOnClickListener {
                listener.goToDetailCategory(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflate(R.layout.adapter_category, parent), listener = listen, ctx = ctx)
    }
}