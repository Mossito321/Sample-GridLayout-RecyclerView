package com.mossinwkung.samplegridlayoutrecyclerview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mossinwkung.samplegridlayoutrecyclerview.R
import com.mossinwkung.samplegridlayoutrecyclerview.adapter.SampleGridAdapter
import com.mossinwkung.samplegridlayoutrecyclerview.adapter.SampleGridLayoutManager
import com.mossinwkung.samplegridlayoutrecyclerview.model.SampleGridModel
import kotlinx.android.synthetic.main.fragment_sample_grid_recycler.*

class SampleGridRecyclerViewFragment : Fragment() {
    companion object {
        const val VIEW_TYPE_ONE = "type_one"
        const val VIEW_TYPE_TWO = "type_two"
        const val VIEW_TYPE_FOUR = "type_four"

        fun newInstance(): SampleGridRecyclerViewFragment {
            return SampleGridRecyclerViewFragment()
        }
    }

    private val GRID_SPAN_COUNT = 4
    private lateinit var sampleGridAdapter: SampleGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample_grid_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val sampleGridItemlist = mutableListOf<SampleGridModel>()
        val sampleGridModel = SampleGridModel().apply {
            title = "One"
            viewType = VIEW_TYPE_ONE
        }
        sampleGridItemlist.add(sampleGridModel)
        for (x in 0..3) {
            val sampleGridModel = SampleGridModel().apply {
                title = "Two"
                viewType = VIEW_TYPE_TWO
            }
            sampleGridItemlist.add(sampleGridModel)
        }
        for (x in 0..7) {
            val sampleGridModel = SampleGridModel().apply {
                title = "Four"
                viewType = VIEW_TYPE_FOUR
            }
            sampleGridItemlist.add(sampleGridModel)
        }
        for (x in 0..3) {
            val sampleGridModel = SampleGridModel().apply {
                title = "Two"
                viewType = VIEW_TYPE_TWO
            }
            sampleGridItemlist.add(sampleGridModel)
        }
        sampleGridItemlist.add(sampleGridModel)
        sampleGridItemlist.add(sampleGridModel)

        sampleGridAdapter = SampleGridAdapter()
        val sampleGridLayoutManager =
            SampleGridLayoutManager(context, GRID_SPAN_COUNT, sampleGridAdapter)
        sampleGridAdapter.let { sampleGridAdapter ->
            sampleGridAdapter.setItemList(sampleGridItemlist)
            sampleGridAdapter.notifyDataSetChanged()
            sampleGridRecyclerView?.layoutManager = sampleGridLayoutManager
            sampleGridRecyclerView?.adapter = sampleGridAdapter
        }
    }
}