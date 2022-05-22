package com.example.ec12.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ec12.R

class Adapterfragments(activity: CarteleraFragment): FragmentStateAdapter(activity){
    private val fragments:List<Fragment> =listOf(
        CarteleraFragment(),
        DetallesFragment()
    )
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}