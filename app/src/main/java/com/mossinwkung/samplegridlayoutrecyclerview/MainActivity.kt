package com.mossinwkung.samplegridlayoutrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mossinwkung.samplegridlayoutrecyclerview.fragment.SampleGridRecyclerViewFragment

class MainActivity : AppCompatActivity() {

    private var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val sampleGridRecyclerViewFragment = SampleGridRecyclerViewFragment.Companion.newInstance()

        setupFragment(sampleGridRecyclerViewFragment)
    }

    private fun setupFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(fragment.toString())
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
}
