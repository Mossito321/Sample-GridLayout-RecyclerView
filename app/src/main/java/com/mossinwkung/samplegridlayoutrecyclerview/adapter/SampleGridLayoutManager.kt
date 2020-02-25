package com.mossinwkung.samplegridlayoutrecyclerview.adapter

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SampleGridLayoutManager(
    context: Context?,
    spanCount: Int,
    val adapter: RecyclerView.Adapter<SampleGridAdapter.SampleGridViewHolder>
) : GridLayoutManager(context, spanCount) {

    private val DEFAULT_SPAN_SIZE = 1
    private val TWO_SPAN_SIZE = 2

    init {
        spanSizeLookup = MovieSpanSizeLookup()
    }

    inner class MovieSpanSizeLookup : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            val viewType = adapter.getItemViewType(position)

            if (adapter is SampleGridAdapter) {
                return when (viewType) {
                    SampleGridAdapter.TYPE_FOUR -> {
                        DEFAULT_SPAN_SIZE
                    }
                    SampleGridAdapter.TYPE_TWO -> {
                        TWO_SPAN_SIZE
                    }
                    else -> {
                        spanCount
                    }
                }
            }
            return DEFAULT_SPAN_SIZE
        }
    }
}