package com.mossinwkung.samplegridlayoutrecyclerview.adapter

import android.view.View
import androidx.core.content.ContextCompat
import com.mossinwkung.samplegridlayoutrecyclerview.R
import com.mossinwkung.samplegridlayoutrecyclerview.model.SampleGridModel
import kotlinx.android.synthetic.main.viewholder_grid_item.view.*

class SampleFourItemViewHolder(val view: View) : SampleGridAdapter.SampleGridViewHolder(view) {
    override fun bind(sampleGridModel: SampleGridModel) {
        itemView.apply {
            relativeLayout.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorItemFour
                )
            )
            titleTextView.text = sampleGridModel.title
        }
    }
}