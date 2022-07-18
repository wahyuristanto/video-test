package com.riztech.vidiotest.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.nioso.core.util.getProgressDrawable
import com.nioso.core.util.loadImage
import com.riztech.vidiotest.R
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.model.Entity
import com.riztech.vidiotest.util.BaseRecylerAdapter
import com.riztech.vidiotest.util.BaseViewHolder
import kotlinx.android.synthetic.main.adapter_list_jokes.view.*

class JokesListAdapter(val ctx: Context): BaseRecylerAdapter<Response.Jokes, JokesListAdapter.ViewHolder>(ctx) {

    lateinit var listen: Listener

    public interface Listener{
        fun goToDetail(category: Response.Jokes)
    }

    class ViewHolder(
        itemView: View,
        val listener: Listener,
        val ctx: Context
    ) :
        BaseViewHolder<Response.Jokes>(itemView) {

        override fun onBind(item: Response.Jokes) {
            itemView.ivIcon.loadImage(item.icon_url, getProgressDrawable(ctx), ctx)
            itemView.tvJoke.text = item.value
            itemView.tvUpdated.text = item.updated_at

            itemView.setOnClickListener {
                listener.goToDetail(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            inflate(R.layout.adapter_list_jokes, parent),
            listener = listen,
            ctx = ctx
        )
    }
}