package com.mossinwkung.samplegridlayoutrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mossinwkung.samplegridlayoutrecyclerview.R
import com.mossinwkung.samplegridlayoutrecyclerview.fragment.SampleGridRecyclerViewFragment.Companion.VIEW_TYPE_FOUR
import com.mossinwkung.samplegridlayoutrecyclerview.fragment.SampleGridRecyclerViewFragment.Companion.VIEW_TYPE_ONE
import com.mossinwkung.samplegridlayoutrecyclerview.fragment.SampleGridRecyclerViewFragment.Companion.VIEW_TYPE_TWO
import com.mossinwkung.samplegridlayoutrecyclerview.model.SampleGridModel

class SampleGridAdapter : RecyclerView.Adapter<SampleGridAdapter.SampleGridViewHolder>() {
    companion object {
        const val TYPE_ONE = 1
        const val TYPE_TWO = 2
        const val TYPE_FOUR = 3
    }

    private val sampleGridModel = mutableListOf<SampleGridModel>()

    abstract class SampleGridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(sampleGridModel: SampleGridModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleGridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_ONE -> SampleOneItemViewHolder(
                view = layoutInflater.inflate(
                    R.layout.viewholder_grid_item,
                    parent, false
                )
            )
            TYPE_TWO -> SampleTwoItemViewHolder(
                view = layoutInflater.inflate(
                    R.layout.viewholder_grid_item,
                    parent, false
                )
            )
            TYPE_FOUR -> SampleFourItemViewHolder(
                view = layoutInflater.inflate(
                    R.layout.viewholder_grid_item,
                    parent, false
                )
            )
            else -> SampleOneItemViewHolder(
                view = layoutInflater.inflate(
                    R.layout.viewholder_grid_item,
                    parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return sampleGridModel.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (sampleGridModel[position].viewType) {
            VIEW_TYPE_ONE -> TYPE_ONE
            VIEW_TYPE_TWO -> TYPE_TWO
            VIEW_TYPE_FOUR -> TYPE_FOUR
            else -> TYPE_ONE
        }
    }

    override fun onBindViewHolder(holder: SampleGridViewHolder, position: Int) {
        val item = sampleGridModel[position]
        holder.bind(item)
    }

    fun setItemList(gridItemList: List<SampleGridModel>) {
        sampleGridModel.clear()
        sampleGridModel.addAll(gridItemList)
    }
}